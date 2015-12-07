import math
def combinations(n,k):
    if k == 2:
        if n <= 9 and n>=0:
            return n+1
        elif n<= 18 and n>=10:
            return combinations(n%9,2)
        else:
            return 0

    combi = 0
    for i in range(n):
        combi += combinations(n-i,k-1)
        print(combi)

    return combi


print(combinations(15, 8))
