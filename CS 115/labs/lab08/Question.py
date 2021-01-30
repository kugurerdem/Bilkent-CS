# -*- coding: utf-8 -*-
"""
Created on Mon Jun 25 09:04:13 2018

@author: user
"""
class Question:
    def __init__(self, question, answer, score):
        self.__questionText = question
        self.__correctAnswer = answer
        self.__score = score
        self.__studentAnswer = None
        
    def getQuestion(self):
        return self.__questionText
    
    def getScore(self):
        if self.isCorrectAnswer():
            return int(self.__score)
        return 0
    
    def getPoints(self):
        return int(self.__score)
    
    def getCorrectAnswer(self):
        return self.__correctAnswer
    
    def getStudentAnswer(self):
        return self.__studentAnswer
    
    def setQuestion(self, question):
        self.__questionText = question
    
    def setAnswer(self, answer):
        self.__correctAnswer = answer   
        
    def setScore(self, score):
        self.__score = int(score)
    
    def setStudentAnswer(self, answer):
        self.__studentAnswer = answer
    
    def answerQuestion(self, stuAnswer):
        self.__studentAnswer = stuAnswer
    
    def isCorrectAnswer(self):
        if self.__studentAnswer == self.__correctAnswer:
            return True
        return False
    
    def displayQuestion(self):
        print(self.getQuestion())
    
    def __str__(self):
        return self.__questionText+'\nYour Answer:'+str(self.__studentAnswer)+'\nCorrect Answer:'+self.__correctAnswer
    
    def __repr__(self):
        return self.__str__()
        