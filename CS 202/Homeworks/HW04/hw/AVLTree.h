/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 4
* Description: header file for AVLTree
*/

#include "BinaryNode.h"
#include <iostream>
#include <string> 
#include <fstream>
using namespace std;

// AVLTree.h
class AVLTree {
public:
    AVLTree(); 
    ~AVLTree();
    void addWord(string word);
    void generateTree(string fileName); //to-do: word seperating
    void printHeight(ofstream& out_file); 
    void printTotalWordCount(ofstream& outFile); 
    void printWordFrequencies(ofstream& outFile);
    void printMostFrequent(ofstream& outFile);
    void printLeastFrequent(ofstream& outFile); 
    void printStandartDeviation(ofstream& outFile);

    // getters
    BinaryNode* getMostFrequent(); 
    BinaryNode* getLeastFrequent(); 
    double getStandartDeviation();
    int getTotalWordCount();
    int getFrequency(); 

private:
    // properties
    BinaryNode* root;

    // helper methods
    void addWord(BinaryNode*& root, string word); 
    void printWordFrequencies(ofstream& outFile, BinaryNode* root);
    BinaryNode* getMostFrequent(BinaryNode* root); 
    BinaryNode* getLeastFrequent(BinaryNode* root); 
    double sumOfVarianceTerms(BinaryNode* root, double mean);
    int getFrequency(BinaryNode* root);

    // AVL tree methods
    int getHeight(BinaryNode* root); 
    int getBalance(BinaryNode* root); 
    int getTotalWordCount(BinaryNode* root); 

    // Balancing methods
    BinaryNode* balance(BinaryNode* root); 
    BinaryNode* leftRotate(BinaryNode* node);  
    BinaryNode* rightRotate(BinaryNode* node);  
    BinaryNode* rightLeftRotate(BinaryNode* node); 
    BinaryNode* leftRightRotate(BinaryNode* node); 

    void destroyTree(BinaryNode*&); 
};