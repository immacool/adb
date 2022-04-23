import os

from os import system, popen
from time import sleep


USER_DIRECTORY = os.path.expanduser('~')
DEFAULT_SCREENSHOT_PATH = os.path.join(USER_DIRECTORY, 'Desktop', 'screenshot.png')


def raw_command(command: str):
    return popen(command).read()


def clean_command(command: str) -> list[str]:
    output = popen(command).read().split('\n')
    # remove empty lines
    while '' in output:
        output.remove('')
    return output


def get_device() -> str:
    devices = clean_command('adb devices')
    if len(devices) < 2:
        return ''
    # get id of first device
    device = devices[1].split('\t')[0]
    return device


def shell(command: str):
    return clean_command('adb shell ' + command)


def is_running(package: str):
    # check if application is running via adb shell pidof {package}
    return len(clean_command(f'adb shell pidof {package}')) > 0


def start(activity: str, package: str, action: str, block: bool = True):
    command = f'am start -a {action} -n {package}/{activity}'
    shell(command)
    print(command)
    if block:
        while not is_running(package):
            sleep(0.1)


def adb_input(command: str):
    command = 'adb shell input ' + command
    print(command)
    return clean_command(command)


def tap(x: int, y: int):
    return adb_input('tap {} {}'.format(x, y))


def text(text: str):
    return adb_input(f"text '\"{text}\"'")


home = lambda: system('adb shell input keyevent KEYCODE_HOME')
apps = lambda: system('adb shell input keyevent KEYCODE_MENU')
back = lambda: system('adb shell input keyevent KEYCODE_BACK')

screeshot = lambda path: system(f'adb exec-out screencap -p > {path or DEFAULT_SCREENSHOT_PATH}')

def chain(steps: str):
    '''
    ### Available commands:\n
    `tap x y` - tap on screen at coordinates x, y\n
    `text 'text'` - write text in focused field\n
    `home` - press home button\n
    `apps` - press apps button\n
    `back` - press back button\n
    `screenshot path` - take screenshot and save on pc at given path (if provided), or to desktop
    '''
    for command in steps.split('\n'):
        action, *args = command.split(' ')
        # remove args after comment (labled with //) from list
        for i, arg in enumerate(args):
            if arg.startswith('//'):
                args = args[:i]
                break

        if action.startswith('!'):
            continue

        if action == 'tap':
            tap(float(args[0]), float(args[1]))
        elif action == 'wait':
            sleep(float(args[0]))
        elif action == 'text':
            text(' '.join(args))
        elif action == 'home':
            home()
        elif action == 'apps':
            apps()
        elif action == 'back':
            back()
        elif action == 'screenshot':
            path = ''.join(args)
            screeshot(path)
