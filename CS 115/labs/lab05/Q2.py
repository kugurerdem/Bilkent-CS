# -*- coding: utf-8 -*-
"""
Created on Wed Jul 10 16:16:26 2019

@author: erdem.seyfi-ug
"""


def inputProducts( names, prices):
    
    name = input('Enter item name (quit to exit): ' )
    while name != 'quit':
        price = float( input('Enter item price: ' ))
        names.append( name)
        prices.append( price)
        name = input('Enter item name (quit to exit): ' )
        
def maxPrice( prices):
    if len(prices) == 0 or prices == None:
        print( ' Invalid price list')
        return None
    else:
        maxIndex = 0
        for i in range( len(prices) ):
            if( prices[maxIndex] < prices[i]):
                maxIndex = i
        return maxIndex

def minPrice( prices):
    if len(prices) == 0 or prices == None:
        print( ' Invalid price list')
        return None
    else:
        minIndex = 0
        for i in range( len(prices) ):
            if( prices[minIndex] > prices[i]):
                minIndex = i
        return minIndex
    
def find_results(list1, list2, func):
    index = func( list2)
    return( list1[ index], list2[ index])

# PROGRAM

names = []
prices = []

inputProducts( names, prices)
(minName, minPrice) = find_results(names, prices, minPrice)
(maxName, maxPrice) = find_results(names, prices, maxPrice)

print( "Item with highest price: {} price: {}".format(maxName, maxPrice ))
print( "Item with lowest price: {} price: {}".format(minName, minPrice ))


    