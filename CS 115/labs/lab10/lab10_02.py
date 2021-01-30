# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 16:11:25 2019

@author: erdem.seyfi-ug
"""

from matplotlib.pyplot import *
from numpy import *
import math

# selectionSort
def selectionSort(L, L2):
    suffixStart = 0
    while suffixStart != len(L):
        for i in range(suffixStart, len(L)):
            if L[i] < L[suffixStart]:
                L[suffixStart], L[i] = L[i], L[suffixStart]
                L2[suffixStart], L2[i] = L2[i], L2[suffixStart]
        suffixStart += 1

# QUESTION 02

subplot(1, 2, 1)
labels = ['China', 'Thailand', 'Australia', 'Brazil', 'Spain',
'Portugal', 'Japan', 'Ethiopia','Canada','Senegal','Poland','Sweden','Argentina','Zimbabwe','Turkey'
]

scores = array([98, 105, 87, 154, 123, 81, 86, 112, 92, 95, 103, 107, 96, 82, 146])
score_sum = sum( scores)
sizes = (scores / score_sum) * 100


explode = (0, 0, 0, 0.1, 0, 0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0)

pie(sizes, explode=explode, labels=labels,autopct='%1.1f%%')

subplot(1, 2, 2)

selectionSort(labels, scores)
index = labels

xticks(rotation=90)
bar(index, scores, 0.5)
title('Comparison of Times by Country')
