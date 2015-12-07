from math import floor
from sys import exit
from copy import deepcopy

def convertToBools(array):
    bools = [False]*16
    for i in array:
        bools[i-1] = True

    findFastestSequence(bools)

def findFastestSequence(array):
    queue = []
    queue.append([array, []])
    finish = False

    while len(queue) > 0:
        game = queue.pop(0)
        for index in range(len(game[0])):
            newGame = deepcopy(game)
            moles = newGame[0]

            if moles[index] == True:
                newGame[1].append(index+1)
                moles[index] = False
                result = whackMole(index, moles)

                if len(result) == 0:
                    printArray(newGame[1])
                    exit()
                else:
                    queue.append([result, newGame[1]])

def whackMole(index, moles):
    if sameLine(index, index-1) and index-1>=0:
        moles[index-1] = not moles[index-1]
    if sameLine(index, index+1):
        moles[index+1] = not moles[index+1]
    if index-4>=0:
        moles[index-4] = not moles[index-4]
    if index+4<=15:
        moles[index+4] = not moles[index+4]

    check = False
    for val in moles:
        if (check == False): check = val

    if check == False:
        return []
    else:
        return moles

def sameLine(a, b):
    if floor((a)/4) == floor((b)/4):
        return True
    else:
        return False

def printArray(array):
    for d in array:
        print(d)

array = [1,4,6,7,10,11,13,16]
convertToBools(array)
