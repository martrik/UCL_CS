from copy import deepcopy

def findCableLen(conNodes, unconNodes):
    totalCable = 0
    conNodes.append(unconNodes.pop(0))

    while len(unconNodes) != 0:
        newNode, newCableDistance = closestNewNodeFromNodes(conNodes, unconNodes)
        conNodes.append(unconNodes.remove(newNode))
        totalCable += newCableDistance

    print("Total cable is: " + str(totalCable))

def closestNewNodeFromNodes(conNodes, unconNodes):
    tempConNodes = deepcopy(conNodes)
    closestNode, distance = closestNodeFromNode(tempConNodes.pop(0), unconNodes)

    for conNode in tempConNodes:
        tempClosestNode, tempDistance = closestNodeFromNode(conNode, unconNodes)
        if tempDistance < distance:
            distance = tempDistance
            closestNode = tempClosestNode

    return closestNode, distance

def closestNodeFromNode(node, nodes):
    otherNodes = deepcopy(nodes)
    tempClosest, distance = otherNodes[0], distanceBetween(node, otherNodes[0])
    otherNodes.remove(otherNodes[0])

    for closeNode in otherNodes:
        tempDistance = distanceBetween(node, closeNode)
        if  tempDistance < distance:
            distance, tempClosest = closeNode, tempDistance

    return tempClosest, distance

def distanceBetween(first, second):
    return abs(first[0]-second[0]) + abs(first[1]-second[1])

findCableLen([],[(4,5),(2,23),(523,53)])
