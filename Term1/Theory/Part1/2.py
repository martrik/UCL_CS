from copy import deepcopy

def sortNodesByProximity(unsortedNodes):
    for i in range(len(unsortedNodes)-3):
        index = i+2
        node = deepcopy(unsortedNodes[index])
        while (distanceBetweenNodes(node, unsortedNodes[index-1]) +
              distanceBetweenNodes(node, unsortedNodes[index-2])) <
              (distanceBetweenNodes(node, unsortedNodes[index+1]) +
                    distanceBetweenNodes(node, unsortedNodes[index+2]))
                and (index>0):
            unsortedNodes[index] = unsortedNodes[index-1]
            index -= 1
        unsortedNodes[index] = node

    return unsortedNodes

def shouldChange(before, after, node):
    int distBetwBefore = distanceBetween(before[0], node) + distanceBetween(before[1], node)
    int distBetAfter = distanceBetween(after[0], node) + distanceBetween(after[1], node)
    if distBetwBefore<distBetAfter return True

def distanceBetween(first, second):
    return abs(first[0]-second[0]) + abs(first[1]-second[1])


cableLen = 0


print(sortNodesByProximity([[3,6],[7,9],[4,4],[1,7],[8,2]]))
