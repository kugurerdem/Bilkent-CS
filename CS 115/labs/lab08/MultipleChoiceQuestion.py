# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 15:43:03 2019

@author: erdem.seyfi-ug
"""

from Question import Question

class MultipleChoiceQuestion( Question):
    def __init__(self, question, answer, score, choices):
        super().__init__(question, answer, score)
        self.__choices = choices
    
    # Override
    def displayQuestion(self):
        print(self.getQuestion())
        
        for choice in self.__choices:
            print( choice)
    
    # -
    def __repr__(self):
        rp = super().__str__()
        for c in self.__choices:
            rp = rp + "\n" + c
            
        return rp
    
    # GETTERS
    def getChoices(self):
        return self.__choices