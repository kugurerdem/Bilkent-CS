# -*- coding: utf-8 -*-
"""
Created on Wed Jul  3 15:43:34 2019

@author: erdem.seyfi-ug
"""

import random

def generate_password( username):
    pas = ''
    
    for i in range( 4):
        randIndex = random.randint(0, len( username) - 1)
        ch = username[ randIndex]
        if random.randint(0, 1) == 1:
            ch = ch.upper()
        else:
            ch = ch.lower()
            
        pas = ch + pas + str( random.randint(0, 9))
    
    return pas

def write_passwords( inputFileName, outputFileName):
    fileReader = open( inputFileName, 'r')
    fileWriter = open( outputFileName, 'w')
    
    current_username = fileReader.readline().strip()
    while current_username:
        new_password = generate_password( current_username)
        fileWriter.write( current_username + ' ' + new_password + '\n')
        current_username = fileReader.readline().strip()
    
    fileWriter.close()
    fileReader.close()
    
