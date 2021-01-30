# -*- coding: utf-8 -*-
"""
Created on Mon Jul  1 16:06:32 2019

@author: erdem.seyfi-ug
"""

import random

# part A
def throwUntil(x):
    '''
    Input : x, number between 2 and 12
    Returns the number of rolls it takes to roll the given sum.
    '''
    count = 0
    dice_total = 0
    while dice_total != x:
        # throwing the dices
        dice_1 = random.randint(1, 6)
        dice_2 = random.randint(1, 6)
        # calculating the new sum of dices
        dice_total = dice_1 + dice_2 
        count = count + 1 # number of trials
    
    return count

# part B

given_sum = int( input(' Enter sum of dice : '))
while given_sum < 2 or given_sum > 12:
    print( ' Sum must be between 2 and 12 inclusive')
    given_sum = int( input(' Enter sum of dice : '))

times = throwUntil( given_sum)
print( " Dice are rolled {} times to get the sum {}".format( times, given_sum) )