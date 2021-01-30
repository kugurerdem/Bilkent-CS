# -*- coding: utf-8 -*-
"""
Created on Wed Jun 26 15:58:30 2019

@author: erdem.seyfi-ug
"""

annual_salary = int( input(' Enter your annual salary : '))
portion_to_save = float( input( ' Enter portion to save : '))
cost_of_house = int( input(' Enter the cost of the house '))

monthly_salary = annual_salary / 12
monthly_saving = monthly_salary * portion_to_save

current_saving = 0
r = 0.04 # annual return of money

month = 0
while current_saving < cost_of_house / 4:
    current_saving = current_saving + current_saving * (r / 12)
    current_saving = current_saving + ( monthly_saving)
    month = month + 1

print( " You need {} month to make a down payment to get the house".format( month))
    
