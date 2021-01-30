# -*- coding: utf-8 -*-
"""
Created on Wed Jul 31 16:24:24 2019

@author: erdem.seyfi-ug
"""

from matplotlib.pyplot import *
from pylab import *
from numpy import *
import math

# QUESTION 03

fileReader = open('seed.txt', 'r')
seeds = fileReader.read().split('\t')
for i in range(0, len(seeds)):
    seeds[i] = int( seeds[i])

# BEST LINE
subplot(2, 1, 1)
title('Order1')
x_axis = arange(0, 15)
plot(x_axis, seeds, 'bo')


fit = polyfit(x_axis, seeds, 1)
predictedValues = polyval(fit, x_axis)

plot(x_axis, predictedValues)  
legend(['y = {0:0.1f} x + {1:0.1f}'.format(fit[0], fit[1]) ])
# BEST POLYNOMIAL
subplot(2, 1, 2)
title('Order2')

plot(x_axis, seeds, 'bo')

fit = polyfit(x_axis, seeds, 2)
predictedValues = polyval(fit, x_axis)

plot(x_axis, predictedValues)  
legend(['y = {0:0.1f} x^2 + {1:0.1f}x + {2:0.2f}'.format(fit[0], fit[1], fit[2]) ])

grid('on')