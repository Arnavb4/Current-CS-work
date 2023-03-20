# FIX: figure out the more clever way to make this (watch out for aliasing)
board = [
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
        [" * ", " * ", " * ", " * ", " * ", " * ", " * "],
    ]

numlist = ['  1  ', '  2  ', '  3  ' , '  4  ', '  5  ', '  6  ', '  7  ']

p1 = input('Who is player 1?')
p2 = input('Who is player 2?')
  
def print_board(list1, list2):

    line = "---------------------------------------------------------------"
    for x in list2:
        print('  ' + x, end = '  ')

        
    print('') 
    
    print(line)
    for x in list1:
        for y in x:
            print( ' | ' + y, end = ' | ')  
        print('')

    print(line)


def turn():
    countX = 0
    countO = 0
    for i in board:
        countX += i.count("X")
        countO += i.count("O")

    if countX > countO:
        omove = int(input(print('It is player ' + p2 + ' turn please press a key from 1-7 to place your marker')))
        move(board, 'O', omove)

    elif countX == countO:
        xmove = int(input(print("It is player " + p1 + ' turn, please press a key from 1-7 to place your marker')))
        move(board, 'X', xmove)



def move(list1, letter, number):
    #  number represents column of board to place 

    bheight = len(list1)
    bwidth = len(list1[0])

    for x in reversed(range(bwidth)):
        for y in range(bheight):
            if number - 1 == y and list1[x][y] == "*":
                list1[x][y] = letter
                return 


def check(list1):
    bwidth = len(list1[0])
    bheight = len(list1)

    #check horizontal
    for y in range(bheight):
        for x in range(bwidth - 3):
            if list1[y][x] == list1[y][x+1] == list1[y][x+2] == list1[y][x+3] == 'X' != "*":
                print(p1 + " won!!!")
                return True
            elif list1[y][x] == list1[y][x+1] == list1[y][x+2] == list1[y][x+3] == 'O' != "*":
                print(p2 + " won!!!")
                return True
    
    #check vertical
    for y in range(bheight - 3):
        for x in range(bwidth):
            if list1[y][x] == list1[y+1][x] == list1[y+2][x] == list1[y+3][x] == 'X' != "*":
                print(p1 + " won!!!")
                return True
            elif list1[y][x] == list1[y+1][x] == list1[y+2][x] == list1[y+3][x] == 'O' != "*":
                print(p2 + " won!!!")
                return True
    
      
    for y in range(bheight - 3):
        for x in range(bwidth - 3):
   
            if list1[y][x] == list1[y+1][x+1] == list1[y+2][x+2] == list1[y+3][x+3] == 'X' != "*":
                print(p1 + " won!!!")
                return True
            elif list1[y][x] == list1[y+1][x+1] == list1[y+2][x+2] == list1[y+3][x+3] == 'O' != "*":
                print(p2 + " won!!!")
                return True
  
    #/
    for y in range(bheight - 3):
        for x in range(3, bwidth):

            if list1[y][x] == list1[y+1][x-1] == list1[y+2][x-2] == list1[y+3][x-3] == 'X' != "*":
                print(p1 + " won!!!")
                return True
            elif list1[y][x] == list1[y+1][x-1] == list1[y+2][x-2] == list1[y+3][x-3] == 'O' != "*":
                print(p2 + " won!!!")
                return True
    



def gameplay():
    # FIX: only playing one turn - need to check()
    while check(board) != True:
        print_board(board, numlist)
        turn()
    print_board(board, numlist)


gameplay()
