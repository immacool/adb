from typing import Union

import cv2
import numpy as np


def locate(image: np.ndarray,
           template: np.ndarray,
           threshold: float = 0.9) -> Union[bool, tuple]:
    img_rgb = cv2.imread(image)
    template = cv2.imread(template)
    w, h = template.shape[::-1][1:]

    res = cv2.matchTemplate(img_rgb, template, cv2.TM_CCOEFF_NORMED)
    threshold = threshold
    loc = np.where(res >= threshold)

    for pt in zip(*loc[::-1]):  # Switch collumns and rows
        cv2.rectangle(img_rgb, pt, (pt[0] + w, pt[1] + h), (0, 0, 255), 2)

    cv2.imwrite('result.png', img_rgb)

    coordinates = list(zip(*loc[::-1]))
    found = bool(coordinates)

    if not found:
        return False, None

    # remove too close points (less than N px) from the list
    N = 10
    while 1:
        duplicate_found = False
        for coord in coordinates:
            for i in range(len(coordinates)):
                # if points not too close remove them
                if abs(coord[0] - coordinates[i][0]) <= N and \
                   abs(coord[1] - coordinates[i][1]) <= N and \
                   i != coordinates.index(coord):
                    print(f'{len(coordinates)} : {coord}')
                    coordinates.remove(coord)
                    duplicate_found = True
                    break

        if not duplicate_found:
            print(f'Found: {len(coordinates)} points')
            return found, coordinates


if __name__ == '__main__':
    locate('data.png', 'find.png')