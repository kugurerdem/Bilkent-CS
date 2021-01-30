# -*- coding: utf-8 -*-
"""
Created on Wed Jun 26 15:51:50 2019

@author: erdem.seyfi-ug
"""

lower_bound = int( input('Enter lower bound : '))
upper_bound = int( input('Enter upper bound : '))

if lower_bound >= upper_bound:
    print( 'Invalid range')
else: 
    summation = 0
    number = 0
    
    for num in range( lower_bound, upper_bound + 1):
        if( num % 7 == 0 and num % 5 != 0 ):
            summation = summation + num
            number = number + 1
    
    print( '{} values are divisible by 7 but not 5 between {} and {}'.format( number, lower_bound, upper_bound))
    
    if number != 0:
        average = summation / number
        print( 'Average Value: {}'.format( average) )
    

            