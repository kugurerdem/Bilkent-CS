# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 15:55:11 2019

@author: erdem.seyfi-ug
"""

from Question import Question

class TrueFalseQuestion( Question):
    def __init__(self, question, answer, score, incPoints):
        super().__init__(question, answer, score)
        self.__incorrectPoints = incPoints
    
    # -
    def __repr__(self):
        rp = "True or False\n"
        rp = rp + super().__str__()
        return rp
    
    # Override
    def getScore(self):
        if self.isCorrectAnswer():
            return self.getPoints()
        return -self.__incorrectPoints
    
    # Override
    def displayQuestion(self):
        print("True or False")
        print(self.getQuestion())
    
    # Getters
    def getIncorrectPoints(self):
        return self.__incorrectPoints