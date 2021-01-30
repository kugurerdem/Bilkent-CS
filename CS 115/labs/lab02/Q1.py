# -*- coding: utf-8 -*-
"""
Created on Wed Jun 26 15:41:03 2019

@author: erdem.seyfi-ug
"""

string = input( ' Enter string: ')
if len(string) < 2:
    out = 2 * string
    for i in range(4-len(out)):
        out = out + '!'
else:
    out = string[0:2] + string[ (len(string) - 2):(len(string))] 

print( out)