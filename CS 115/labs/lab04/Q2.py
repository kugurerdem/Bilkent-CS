# -*- coding: utf-8 -*-
"""
Created on Wed Jul  3 15:39:20 2019

@author: erdem.seyfi-ug
"""

import lab04_module

inputFileName = input( ' Enter the input file name : ')
outputFileName = input( ' Enter the output file name : ')

lab04_module.write_passwords( inputFileName, outputFileName)
print( ' Passwords are created into the given output file name')
