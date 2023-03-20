def createNewBoard(): 
    new = (".",".",".",".",".",".",".")
    new_list = []
    list_to_create_file = []
    l1 = list(new)
    l2 = list(new)
    l3 = list(new)
    l4 = list(new)
    l5 = list(new)
    l6 = list(new)
    new_list.append(l1)
    new_list.append(l2)
    new_list.append(l3)
    new_list.append(l4)
    new_list.append(l5)
    new_list.append(l6)
    for listy in new_list: 
            list_to_create_file.append("".join (listy))
    with open("savegame.txt", "w") as savegame:
        for line in list_to_create_file:
            savegame.write("".join(line))
            savegame.write("\n") 

def createBoard():
    boardList = []
    charList = []
    boardString = ""
    with open("board.txt") as board: 
        for line in board:
            for char in line.strip(): 
                charList.append(char) 
            boardList.append(charList) 
            charList = []
    counter = 0
    for line in boardList:
        counter += 1
        if counter != 6:
            boardString += "".join(line)
            boardString +=("\n")
        else:
            boardString += "".join(line)
    newBoardString = ''
    counter = 0
    print("--------------------------------")
    for character in boardString:
        counter += 1
        if counter == 1: 
            character = character + " |"
            newBoardString = " |" + newBoardString + " " + character 
            #print(newBoardString) 
        else:
            character = character + " |"
            newBoardString = newBoardString + " " + character 
    print(newBoardString)  
    print("--------------------------------") 
    print("   0", "  1", "  2", "  3", "  4", "  5", "  6")
    return ""


def saveGame(boardList):   
    with open("savegame.txt", "w") as savegame:
        for line in boardList:
            savegame.write("".join(line))
            savegame.write("\n") 
    print("Game saved!")  

def start():
    boardList = []
    print("game has begun")
    answer = input("New game (N) or load savegame (L)? ") 
    if answer == "N":
        print("Here's your new board!")
        with open("board.txt", "w") as board:
            for i in range (6):
                board.write(".......")
                board.write("\n")
        print(createBoard()) 
        with open("newBoard.txt") as board: 
            for line in board: 
                boardList.append(list(line.strip()))
        return makeMoveX(boardList)
    elif answer == "L":
        with open("savegame.txt") as board:
            for line in board:
                boardList.append(list(line.strip()))
        with open("board.txt", "w") as board:
            for line in boardList:
                board.write("".join(line))
                board.write("\n")
        print("Game loaded.")
        print(createBoard())
        return makeMoveX(boardList)

def check_horizontal(board):
    for list in board:
        for i in range (4):
            if list [i] == "X" and list [i + 1] == "X" and list [i + 2] == "X" and list [i + 3] == "X":
                return ["True", "X"]
            if list [i] == "O" and list [i + 1] == "O" and list [i + 1] == "O" and list [i + 1] == "O":
                return ["True", "O"]
    return "False"

def check_vertical(board):
    for j in range (3):
        for i in range(len(board[0])):
            if board[j][i] == "X" and board[j+1][i] == "X" and board[j+2][i] == "X" and board[j+3][i] == "X":
                return ["True", "X"]
            if board[j][i] == "O" and board[j+1][i] == "O" and board[j+2][i] == "O" and board[j+3][i] == "O":
                return ["True", "O"]
    return "False"

def check_diagonal(board):
    for j in range (3):
        for i in range(4):
            if board[j][i] == "X" and board[j+1][i + 1] == "X" and board[j+2][i + 2] == "X" and board[j+3][i + 3] == "X":
                return ["True", "X"]
            if board[j][i] == "O" and board[j+1][i + 1] == "O" and board[j+2][i + 2] == "O" and board[j+3][i + 3] == "O":
                return ["True", "O"]
            if board[j + 3][i] == "X" and board[j + 2][i + 1] == "X" and board[j + 1][i + 2] == "X" and board[j][i + 3] == "X":
                return ["True", "X"]
            if board[j + 3][i] == "O" and board[j + 2][i + 1] == "O" and board[j + 1][i + 2] == "O" and board[j][i + 3] == "O":
                return ["True", "O"]
    return "False"

def makeMoveX(gameBoard): 
    i = 5
    userInput = "" 
    userInput = input("Player X: Which column would you like to place your piece in? Or type S to save and Q to quit ") 
    if userInput == "Q":
        print("Thank you for playing <3 ")
        exit()
    elif userInput == "S":
        with open("savegame.txt", "w") as board:
            for line in gameBoard:
                board.write("".join(line))
                board.write("\n")
        print("Game saved.")
        exit() 
    while int(userInput) >= 7 or int(userInput) <= -1: 
        print("--invalid--\n please insert a number from 0 - 6") 
        userInput = input("Which column would you like to place your piece in? ")
    if userInput == "Q":
        exit()
    elif userInput == "S":
        with open("savegame.txt", "w") as board:
            for line in gameBoard:
                board.write("".join(line))
                board.write("\n")
        print("Game saved.")
        exit()
    while gameBoard[i][int(userInput)] == "X" or gameBoard[i][int(userInput)] == "O":
        i = i - 1
    gameBoard[i][int(userInput)] = "X"
    print(gameBoard) 
    with open("board.txt", "w") as board:
        for listies in gameBoard:
            board.write("".join(listies)) 
            board.write("\n")
    print(createBoard())
    tempy = list (check_diagonal(gameBoard))
    tempy2 = list (check_horizontal(gameBoard))
    tempy3 = list (check_vertical(gameBoard))
    if tempy[0] == "True":
        print ("Player", tempy [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit()
    if tempy2[0] == "True":
        print ("Player", tempy2 [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit()
    if tempy3[0] == "True":
        print ("Player", tempy2 [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit() 
    return makeMoveO(gameBoard)

def makeMoveO(gameBoard): 
    i = 5
    userInput = "" 
    userInput = input("Player O: Which column would you like to place your piece in? Or type S to save and Q to quit ")
    if userInput == "Q":
        exit()
    elif userInput == "S":
        with open("savegame.txt", "w") as board:
            for line in gameBoard:
                board.write("".join(line))
                board.write("\n")
        print("Game saved.")
        exit()
    while int(userInput) >= 7 or int(userInput) <= -1: 
        print("--invalid--\n please insert a number from 0 - 6") 
        userInput = input("Which column would you like to place your piece in? ")
    if userInput == "Q":
        exit()
    elif userInput == "S":
        with open("savegame.txt", "w") as board:
            for line in gameBoard:
                board.write("".join(line))
                board.write("\n")
        print("Game saved.")
        exit()
    while gameBoard[i][int(userInput)] == "X" or gameBoard[i][int(userInput)] == "O":
        i = i - 1
    gameBoard[i][int(userInput)] = "O"
    print(gameBoard) 
    with open("board.txt", "w") as board:
        for listies in gameBoard:
            board.write("".join(listies)) 
            board.write("\n") 
    print(createBoard())
    tempy = list (check_diagonal(gameBoard))
    tempy2 = list (check_horizontal(gameBoard))
    tempy3 = list (check_vertical(gameBoard))
    if tempy[0] == "True":
        print ("Player", tempy [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit()
    if tempy2[0] == "True":
        print ("Player", tempy2 [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit()
    if tempy3[0] == "True":
        print ("Player", tempy2 [1], "has won the game")
        with open ("board.txt", "w") as board:
            for i in range(6):
                board.write(".......")
                board.write("\n")
        exit() 
    return makeMoveX(gameBoard)

start() 