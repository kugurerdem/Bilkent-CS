# -*- coding: utf-8 -*-
"""
Created on Mon Jul  1 15:58:02 2019

@author: erdem.seyfi-ug
"""

# part A
def isPrime( n):
    ''' 
    Input : n, an integer number that is greater than 1
    Returns False if n is not prime, True if it is prime 
    '''
    
    for i in range (2, n):
        if n % i == 0:
            return False
    
    return True


# part B
a = int( input( 'Enter a positive integer a: ' ))
abs_a = abs( a)

for num in range(2, abs_a + 1):
    if isPrime( num):
        print( num)

