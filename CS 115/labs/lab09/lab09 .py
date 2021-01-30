# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

def selectionSort(L, L2):
    suffixStart = 0
    while suffixStart != len(L):
        for i in range(suffixStart, len(L)):
            if L[i] < L[suffixStart]:
                L[suffixStart], L[i] = L[i], L[suffixStart]
                L2[suffixStart], L2[i] = L2[i], L2[suffixStart]
        suffixStart += 1


def linearSearch( l, val, index):
    if index == len( l):
        return -1
    
    elif l[ index] == val:
        return index
    
    else:
        return linearSearch( l, val, index + 1)
    
    
def readFile( fileName, emptyList):
    fileReader = open( fileName, 'r')
    
    for l in fileReader:
        line = l[:-1]
        emptyList.append( line)
        
    fileReader.close()

# PROGRAM
users = []
passwords = []

readFile( "users.txt", users)
readFile( "passwords.txt", passwords)

username = input('Enter name of user to get password: ')
index = linearSearch( users, username, 0)

if index == -1:
    print( "User not found!")
else:
    print( username, " has the password: ", passwords[ index])


