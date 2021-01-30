# -*- coding: utf-8 -*-
"""
Created on Mon Jul 22 15:43:51 2019

@author: erdem.seyfi-ug
"""

class Flight( object):
    flightOperatingCost = 150
    
    # CONSTURCTOR
    def __init__(self, fNo, dep, dest, cap):
        self.__flightNo = fNo
        self.__destination = dest
        self.__departure = dep
        self.__capacity = cap
    
    # SETTERS
    def setFlightNo( self, v):
        self.__flightNo = v
    
    def setDestination( self, v):
        self.__destination = v
    
    def setDeparture( self, v):
        self.__departure = v
    
    def setCapacity( self, v):
        self.__capacity = v
    
    # GETTERS
    def getFlightNo( self):
        return self.__flightNo
    
    def getDestination( self):
        return self.__destination
    
    def getDeparture( self):
        return self.__departure
    
    def getCapacity( self):
        return self.__capacity
    
    # METHODS
    
    def calculateOperatingCost(self):
        return self.flightOperatingCost * self.__capacity
    
    def __repr__(self):
        repStr = '\n Flight Number: {}\n Departing From: {}\n Arriving To: {}\n Seats: {}\n'
        repStr = repStr.format(self.__flightNo, self.__departure, self.__destination, self.__capacity)
        
        return repStr
    
    def __lt__(self, anotherFlight):
        return self.__flightNo < anotherFlight.getFlightNo()
