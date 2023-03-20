alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
def c_sub(codedtext):
    response=""
    print("Encoded text:")
    print(codedtext)
    while response!="quit":
        for letter in alpha:
            print(letter,"occurs in the text this many times:"," ",codedtext.count(letter))
        print("Reminder: The most common letters in English are usually: ETAOINSHRDLU")
        response=input("Type a pair of letters to swap, for example AB would swap A and B, or type 'quit': ")
        codedtext=codedtext.replace(response[0],"var1")
        codedtext=codedtext.replace(response[1],"var2")
        codedtext=codedtext.replace("var1",response[1])
        codedtext=codedtext.replace("var2",response[0])
        print(codedtext)

import sys
c_sub(sys.argv[1])