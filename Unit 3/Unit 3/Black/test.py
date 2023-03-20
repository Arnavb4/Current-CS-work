from random import randint
import time
time.sleep(1.5)

board = [["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
         ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"]]

rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]

large_position_list = []
turns = 40

def create_board(board, ships_board):
    global turns

    if turns == 0:
        print("Game Over. The ships were here:")
        print("")
        columns = "    0  1  2  3  4  5  6  7  8  9"
        print(columns)
        print("")

        newlist = []
        for i in range(10):
            newlist.append(rows[i] + "  ")
            for element in ships_board[i]:
                newlist.append(' ' + element + ' ')
            str_list = ""
            for element in newlist:
                str_list = str_list + element
            print(str_list)
            newlist = []
        quit()

    print("Turns: " + str(turns))
    print("Current gameboard:")
    print("")
    columns = "    0  1  2  3  4  5  6  7  8  9"
    print(columns)
    print("")

    newlist = []
    for i in range(10):
        newlist.append(rows[i] + "  ")
        for element in board[i]:
            newlist.append(' ' + element + ' ')
        str_list = ""
        for element in newlist:
            str_list = str_list + element
        print(str_list)
        newlist = []

    move(board, ships_board)




def ships():
    ships_board = [["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"],
                   ["*", "*", "*", "*", "*", "*", "*", "*", "*", "*"]]
    nums = [3, 4, 5]
    for i in range(3):
        x = randint(0, 1)
        length = nums[i]
  
        #horizontal ship
        val1 = False
        while val1 == False:
            x = randint(0, 1)
            if x == 0:
                randrow = randint(0, 9)
                if length == 3:
                    randcol = randint(0, 7)
                elif length == 4:
                    randcol = randint(0, 6)
                else:
                    randcol = randint(0, 5)
                newlist = []
                position_list = []
                for x in range(length):

                    newlist.append(ships_board[randrow][randcol+x])
                    position_list.append(str(randrow) + str(randcol+x))

            elif x == 1:
                randcol = randint(0, 9)
                if length == 3:
                    randrow = randint(0, 7)
                elif length == 4:
                    randrow = randint(0, 6)
                else:
                    randrow = randint(0, 5)
                newlist = []
                position_list = []
                for x in range(length):
                    newlist.append(ships_board[randrow+x][randcol])
                    position_list.append(str(randrow+x) + str(randcol))

            if "X" not in newlist:
                val1 = True
        large_position_list.append(position_list)

        for element in position_list:
            a = int(element[0])
            b = int(element[1])
            ships_board[a][b] = "X"

    create_board(board, ships_board)



def move(board, ships_board):
    global turns

    if turns == 0:
        create_board(ships_board, ships_board)
        quit()

    print("")
    row_input = str(input("Row (or Q to quit): "))
    if row_input == "Q":
        quit()
    row = rows.index(row_input)
    column = int(input("Column: "))
    
    while (row > 9) or (column > 9) or (board[row][column] != "*"):
        print("")
        print("Invalid location, please try again...")
        row_input = str(input("Row: "))
        row = rows.index(row_input)
        column = int(input("Column: "))

    if ships_board[row][column] == "$":
        print("HIT!")
        print("")
        board[row][column] = "X"
    else:
        print("MISS :(")
        print("")
        turns -= 1
        board[row][column] = "O"
    create_board(board, ships_board)

#function calls
ships()