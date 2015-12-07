import time

def fixedDigit(digits, sum):
    global sumMatrix

    if digi == 0 or sum == 0:
        return 1

    if sumMatrix[digi][sum] != -1:
        return sumMatrix[d][sum]

    ans = 0
    for i in range(10):
        if sum-i>=0 and d > 0:
            ans += fixedDigit(digi-1, sum-i)

    sumMatrix[digi][sum] = ans

    return ans


digits = 200
number = 200

# Creates matrix of number+1 columns and digits+1 rows
sumMatrix = [[-1 for x in range(number+1)] for x in range(digits+1)]

print(fixedDigit(digits, number))
