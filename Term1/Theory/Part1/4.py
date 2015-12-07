import math
from copy import deepcopy
import time
combinations = 0

def nextNum(number, i):
    array = deepcopy(number)
    print(array)
    print(i)
    calcPermu(array)
    if i+2<=len(array)-1:
        if array[i+1]-array[i+2]>1:
            array[i+1] -= 1
            array[i+2] += 1
            nextNum(array,i+1)

    if array[i]-array[i+1]>1:
        array[i] -= 1
        array[i+1] += 1
        arraySort(array,i+2)
        nextNum(array,i)
    elif i+1<=len(array)-1:
        if array[i-1]-array[i+1]>1 and array[i] != array[i+1]:
            arraySort(array,i)
            array[i-1] -= 1
            array[i] += 1
            nextNum(array,i-1)
    else:
        return

def arraySort(array, i):
    counter = i;
    while counter<len(array)-1:
        if array[counter]>array[counter+1]:
            (array[counter], array[counter+1]) = (array[counter+1], array[counter])
            counter += 1
        else: break

def calcPermu(number):
    global combinations
    array = [0,0,0,0,0,0,0,0,0,0]
    for i in number:
        array[i] += 1
    div = 1

    for t in array:
        div *= math.factorial(t)
    combinations += math.factorial(len(number))/div


start = time.time()
nextNum([9,7,0,],0)
end = time.time()
print(combinations)
print(end - start)
