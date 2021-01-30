# -*- coding: utf-8 -*-
"""
Created on Wed Jul 10 15:41:10 2019

@author: erdem.seyfi-ug
"""

garage = { }

def addCar( plate_num, owner_name):
    garage[ plate_num] = [ car_owner]
    print( "Car successfully added")
        
def updateCar( plate_num, owner_name):
    if plate_num in garage: 
        garage[ plate_num].append( owner_name)
    else:
        print( "Car is not found")

def findCar( plate_num):
    try:
        return garage[ plate_num]
    except:
        return None


choice = -1
while choice != 4:
    print( "\n1)Add Car \n2)Search Car \n3)Update Owner \n4)Quit")
    choice = int( input('Enter choice: '))
    
    if choice < 1 or choice > 4:
        print(" Invalid command")
    elif choice != 4:
        plate_number = input('Enter plate number: ')
        if choice == 1:
            if plate_number in garage:
                print( "Car already exist")
            else:
                car_owner = input( 'Enter name of owner: ')
                addCar( plate_number, car_owner)
        elif choice == 2:
            prev_owners = findCar( plate_number)
            
            if prev_owners:
                print("List of previous owners: {}".format(prev_owners) )
            else:
                print("Car not found")
        elif choice == 3:
            car_owner = input("Enter name of owner to add: ")
            
            updateCar( plate_number, car_owner)
            
    
    