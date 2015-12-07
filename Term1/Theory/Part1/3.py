def ticketsNumbersUntilPosition(first, position):
    tickets = [first]
    for i in range(position-1):
        tickets.append((tickets[-1]*31334)%31337)

    bigger = 0
    number = tickets[position-1]

    for t in range(len(tickets)-1):
        if (number >= tickets[t]): bigger += 1

    return bigger+1

print(ticketsNumbersUntilPosition(1256, 1337431))
