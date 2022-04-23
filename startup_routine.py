from utils import *

while not (device := get_device()):
    print('Waiting for device...', end='\r')
    sleep(0.1)

print(f'Device: {device}')

telegram_package = 'org.telegram.messenger'
telegram_activity = 'org.telegram.ui.LaunchActivity'
vk_package = 'com.vkontakte.android'
vk_activity = 'com.vkontakte.android.MainActivity'
discord_package = 'com.discord'
discord_activity = 'com.discord.app.AppActivity$Main'

action_main = 'android.intent.action.MAIN'

# start telegram
start(telegram_activity, telegram_package, action_main)

# get daily market
chain('''  
wait 1       // wait telegram to load
tap 598 657  // open channel
wait 0.5     // wait channel to load
tap 749 2158 // open commands
wait 0.5     // wait for animation
tap 607 2060 // write command
back         // close keyboard
back         // go to channels
''')

# start VK
start(vk_activity, vk_package, action_main)

# open messages tab
chain('''
wait 1
tap 530 2156
tap 530 2156
''')

# start discord
chain('''
home 
tap 173 1431 // open group
wait 0.1     // wait for animation
tap 537 801  // open discord
home         // go home
back         // close group
tap 907 1434 // open schedule
wait 3       // wait for loading
screenshot   // take a screenshot
home         // go home again
''')

system(DEFAULT_SCREENSHOT_PATH)
