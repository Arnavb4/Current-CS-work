from random import randint

num_moves = 50

def actboard(gameboard, displayed_board):
    if num_moves == 0:
        print("RIP u didn't get them all. Play again!")
        quit()
    if num_moves == 30:
        displayed_board = [["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                        ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"]]
    row_labels = ["A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J"]
    print("Newest gameboard:")
    print("   ", "0  1  2  3  4  5  6  7  8  9")
    for x in range(10):
        if x == 9:
            print(row_labels[x]," ", "  ".join(displayed_board[x]))
        else:
            print(row_labels[x], "  ".join(displayed_board[x]))
    gameplay(gameboard, displayed_board)

def rando_ships():
    len_ships = [2, 3, 4, 5]
    a = ["Horizontal", "Vertical"]
    mod_list = []
    locations = []
    displayedboard = [["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"]]
    gameboard = [["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"]]
    for len in range(4):
        row_labels = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
        ship_len = len_ships[len]
        ship_bool = False
        while ship_bool == False:
            horizontal_bool = a[randint(0, 1)]
            if horizontal_bool == "Horizontal":
                ship_row = randint(0,9)
                if ship_len == 2:
                    ship_col = randint (0,8)
                elif ship_len == 3:
                    ship_col = randint (0,7)
                elif ship_len == 4:
                    ship_col = randint (0,6)
                else:
                    ship_col = randint (0,5)
                for i in range(ship_len):
                    locations.append((str(ship_row)) + str(ship_col + i))
                    mod_list.append(gameboard[ship_row][ship_col + i])
            else:
                ship_col = randint(0,9)
                if ship_len == 2:
                    ship_row = randint (0,8)
                elif ship_len == 3:
                    ship_row = randint (0,7)
                elif ship_len == 4:
                    ship_row = randint (0,6)
                else:
                    ship_row = randint (0,5)
                for i in range(ship_len):
                    locations.append((str(ship_row + i)) + str(ship_col))
                    mod_list.append(gameboard[ship_row + i][ship_col])
            if "%" not in mod_list:
                ship_bool = True
        for i in locations:
            col = i[1]
            row = i[0]
            gameboard [int(row)][int(col)] = "%"
    actboard(gameboard, displayedboard)

def gameplay(gameboard, displayed_board):
    win_counter = 0
    global num_moves
    row_labels = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]
    print ("THIS IS WAR: BATTLESHIP!")
    row_move = (str(input("Your row pls (insert letter) or q to quit: ")))
    if row_move == "q":
        quit()
    act_row = int(row_labels.index(row_move))
    col_move = (int(input("Your column pls (insert number) or q to quit: ")))
    if col_move == "q":
        quit()
    elif int(col_move) > 9:
        print("Ain't on board, try again: ")
        col_move = (int(input("Your column pls or q to quit: ")))
    # elif col_move != str:
    #     print("Ain't on board, try again: ")
    #     col_move = (int(input("Your column pls or q to quit: ")))
    if gameboard [act_row][col_move] == "%":
        print("AYYY You got a hit!")
        replaced_line = "".join(displayed_board [act_row][0: col_move]) + "X" + "".join(displayed_board[act_row][col_move + 1:11])
        temp = []
        for char in replaced_line:
            temp.append(char)
        displayed_board.remove(displayed_board[act_row])
        displayed_board.insert(act_row, temp)
        num_moves -= 1
        print("# of moves left:", num_moves)
        win_counter += 1
        if win_counter == 14:
            print("Congrats you beat the game!")
            quit()
    else:
        print("Sigh...wrong place try again")
        replaced_line = "".join(displayed_board [act_row][0: col_move]) + "O" + "".join(displayed_board[act_row][col_move + 1:11])
        temp = []
        for char in replaced_line:
            temp.append(char)
        displayed_board.remove(displayed_board[act_row])
        displayed_board.insert(act_row, temp)
        num_moves -= 1
        print("# of moves left:", num_moves)
    actboard(gameboard, displayed_board)

rando_ships ()