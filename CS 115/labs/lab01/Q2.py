# -*- coding: utf-8 -*-
"""
Created on Mon Jun 24 15:58:53 2019

@author: erdem.seyfi-ug
"""

a = int( input(' enter the value of a : '))
b = int( input(' enter the value of b : '))
c = int( input(' enter the value of c : '))

if a <= b and b <= c:
    print( "The sorted nums are {} {} {} ".format( a, b, c))
elif b <= a and a <= c:
    print( "The sorted nums are {} {} {} ".format( b, a, c))
elif a <= c and c <= b:
    print( "The sorted nums are {} {} {} ".format( a, c, b))          
elif c <= a and a <= b:
    print( "The sorted nums are {} {} {} ".format( c, a, b))
elif b <= c and c <= a:
    print( "The sorted nums are {} {} {} ".format( b, c, a))
else:
    print( "The sorted nums are {} {} {} ".format( c, b, a))

    