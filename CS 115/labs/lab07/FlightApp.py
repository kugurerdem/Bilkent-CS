# -*- coding: utf-8 -*-
"""
Created on Mon Jul 22 16:01:25 2019

@author: erdem.seyfi-ug
"""

from Flight import Flight

flightList = []

flightList.append( Flight("TK1234", "Ankara", "Antalya", 250))
flightList.append( Flight("LH8686", "Munich", "Tokyo", 290))
flightList.append( Flight("TK9897", "Istanbul", "Paris", 195))
flightList.append( Flight("TK5432", "Antalya", "Ankara", 250))

print( "Original list: \n {}".format(flightList))
flightList.sort()
print( "Sorted list: \n {}".format(flightList ))

total_cost = 0
tokyoFlights = []

isFound = False
for fl in flightList:
    total_cost = total_cost + fl.calculateOperatingCost()
    if fl.getDestination() == "Tokyo":
        tokyoFlights.append( fl)
        isFound = True

print( "Total Operating Cost: {}".format(total_cost) )
if( isFound ):
    print( "\nFlights whose destination are Tokyo \n\n{}".format(tokyoFlights))
else:
    print(" Flight not found")

