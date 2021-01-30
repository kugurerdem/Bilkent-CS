# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

from matplotlib.pyplot import *
from numpy import *
import math


# QUESTION 01
x_axis = linspace(-2*math.pi, 2*math.pi, 25)
cos_plots = []
sin_plots = []

for x in x_axis:
    sin_plots.append( sin(x))
    cos_plots.append( cos(x))
    

plot(x_axis, cos_plots, 'b:')
plot(x_axis, sin_plots, 'ro--')
axis([-2*math.pi, 2*math.pi, -1, 1])


grid('on')



legend( ['y = cos(x)', 'y = sin(x)'])
