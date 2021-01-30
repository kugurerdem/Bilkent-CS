# -*- coding: utf-8 -*-
"""
Created on Mon Jun 24 16:14:28 2019

@author: erdem.seyfi-ug
"""

storage_unit = int( input( ' Enter a positive integer value: '))
if storage_unit <= 0:
    print( ' You should ener a positive value!')
else:
    value_unit = input( ' Enter the unit of the value (bit/byte/kilobyte): ')
    if value_unit != 'bit' and value_unit != 'byte' and value_unit != 'kilobyte':
        print( 'Invalid unit')
    else:
        conv_unit = input( ' What unit do you want (bit/byte/kilobyte): ')
        if conv_unit != 'bit' and conv_unit != 'byte' and conv_unit != 'kilobyte':
            print( 'Invalit conversion unit')
        else:
            if storage_unit <= 0:
                print( "units must be positive")
            else:    
                converted_value = storage_unit    
                if value_unit == 'bit':
                    converted_value = converted_value * 1
                elif value_unit == 'byte':
                    converted_value = converted_value * 8
                elif value_unit == 'kilobyte':
                    converted_value = converted_value *  1024 * 8
                    
                if conv_unit == 'bit':
                    converted_value = converted_value / 1
                elif conv_unit == 'byte':
                    converted_value = converted_value / 8
                elif conv_unit == 'kilobyte':
                    converted_value = converted_value / (1024 * 8)
    
                
                print( "{} {} is {} {}".format( storage_unit, value_unit, converted_value, conv_unit) ) 