# -*- coding: utf-8 -*-
"""
Created on Wed Jul 17 15:41:41 2019

@author: erdem.seyfi-ug
"""


# PART A

def max_chars( l1):
    max_lengths = []
    row_len = len( l1)
    col_len = len( l1[0] )
    
    for i in range( col_len):
        max_len = 0
        for j in range( row_len):
            if len(l1[j][i]) > max_len:
                max_len = len(l1[j][i])
        max_lengths.append( max_len)
             
    return max_lengths

# PART B
    
def read_words( row_num, col_num):
    rows = []
    for i in range( row_num):
        collumn = []
        for j in range( col_num):
            word = input(' Enter a word: ')
            collumn.append( word)
        rows.append( collumn)
    
    return rows

# PART C

row_num = int( input('Enter number of rows: '))
col_num = int( input('Enter number of collumns: '))

print( " Max Length of words in each column: {}".format( max_chars( read_words(row_num, col_num) )))
