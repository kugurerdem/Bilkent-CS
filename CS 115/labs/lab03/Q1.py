# -*- coding: utf-8 -*-
"""
Created on Mon Jul  1 15:47:41 2019

@author: erdem.seyfi-ug
"""

import random

# part A
def displayMatrix(a , b):
    """
    Input : a, a positive int
            b, another positive int
    Displays an a x b matrix. 
    """
    
    for i in range(0, a):
        line = ""
        for j in range(0, b):
            line = line + ' ' + str( random.randint(0, 1))
        print( line)

# part B
m = int( input('Enter a positive integer (m): '))
n = int( input(' Enter a positive integer (n): '))

displayMatrix(m, n)