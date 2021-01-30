# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 16:01:25 2019

@author: erdem.seyfi-ug
"""

from Question import Question
from MultipleChoiceQuestion import MultipleChoiceQuestion
from TrueFalseQuestion import TrueFalseQuestion

def initializeQuestions(fileName, ls):
    fileReader = open(fileName, 'r')
    for ln in fileReader:
        line = ln[:-1]
        commands = line.split(";")
        
        questionType = commands[0]
        question = commands[1]
        answer = commands[2]
        points = int( commands[3])
        
        if questionType == "T":
            deductPoint = int( commands[4])
            ls.append( TrueFalseQuestion(question, answer, points, deductPoint))
        
        elif questionType == "M":
            choices = commands[4].split(',')
            ls.append( MultipleChoiceQuestion(question, answer, points, choices))
        
        elif questionType == "R":
            ls.append( Question(question, answer, points))
        
        else:
            print( " Invalid question type")
            
        
def gradeExam( questions):
    total_score = 0
    print("*****************Grading Exam*****************")
    for question in questions:
        total_score += question.getScore()
        
        if not question.isCorrectAnswer():
            print( "Incorrect Answer")
            print( question)
        
    print("*****************END OF GRADING*****************")
    print("Your score is ", total_score)
    
questionList = []
initializeQuestions( "questions.txt", questionList)

for question in questionList:
    question.displayQuestion()
    ans = input('Enter choice: ')
    question.setStudentAnswer( ans)

gradeExam( questionList)