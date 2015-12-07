
from copy import deepcopy

def calculateBags(candies):
    tempCandies = deepcopy(candies)
    for i in range(len(candies)-1):
        tempCandies[0] = mcd(tempCandies[0], tempCandies[1])
        tempCandies.pop(1)

    candiesPerBag = 0
    for candi in candies:
        candiesPerBag += candi/tempCandies[0]

    print(str(tempCandies[0]) + " " + str(candiesPerBag))

def mcd(first, second):
    (a, b) = (first, second)
    while b != 0:
        (a,b) = (b, a%b)
    return a

calculateBags([203490, 246772, 386954, 395998, 471580])
