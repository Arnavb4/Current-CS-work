from random import randint


def actboard(gameboard):
    standard_board = [["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"],
                    ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"]]
    list1 = []
    row_labels = ["A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J"]
    elem_string = ""
    print("Newest gameboard:")
    print("0 1 2 3 4 5 6 7 8 9")
    for x in range(10):
        list1.append(row_labels[x])
        for i in standard_board[x]:
            list1.append("  " + i + "  ")
        for i in list1:
            elem_string += i
        print(elem_string)
        list1 = []
    gameplay(gameboard)

def rando_ships():
    len_ships = [2, 3, 4, 5]
    a = ["Horizontal", "Vertical"]
    mod_list = []
    locations = []
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
        ship_len = len_ships[len]
        ship_bool = False
        while ship_bool != True:
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
                ship_bool != True

        for i in locations:
            col = i[1]
            row = i[0]
            gameboard[row][col] = "%"
    actboard(gameboard)

def gameplay(gameboard):
    row_labels = ["A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J"]
    print ("THIS IS WAR: BATTLESHIP!")
    row_move = (str(input("Your row pls or q to quit: ")))
    if row_move == "q":
        quit()
    elif row_move > 9:
        print("Ain't on board, try again: ")
        row_move = (str(input("Your row pls or q to quit: ")))
        act_row = row_labels.index(row_move)
    col_move = (str(input("Your column pls or q to quit: ")))
    if col_move == "q":
        quit()
    elif col_move > 9:
        print("Ain't on board, try again: ")
        col_move = (str(input("Your column pls or q to quit: ")))
    if gameboard [act_row][col_move] == "%":
        print("AYYY You got a hit!")
        gameboard [act_row][col_move] == "X"
    else:
        print("Sigh...wrong place try again")
        gameboard [act_row][col_move] == "O"
    actboard(gameboard)

rando_ships
