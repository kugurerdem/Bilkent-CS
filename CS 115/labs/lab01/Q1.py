# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import math

# inputs

a = int( input( 'enter the coefficient of x^2 : ') )
b = int( input( 'enter the coefficient of x : ') )
c = int( input( 'enter the constant term : ') )

d = (b**2 - 4*a*c)
if d < 0:
    print( "There is no real number solution for this equation")
elif d == 0:
    print( "There is one solution for this equation")
    x = -b / (2*a)
    print( "The solution is : " + str( x) )
else:
    print( "There are two solutions for the equation")
    disc = math.sqrt( d)
    x_1 = (-b + disc) / 2*a
    x_2 = (-b - disc) / 2*a
    
    print( " x_1 = {0:0.2f}, \n x_2 = {1:0.2f}".format( x_1, x_2) )
    