/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 2
* Description: header file for NGramTree
*/

#include "BinaryNode.h"
#include <iostream>
#include <string> 
#include <fstream>
using namespace std;

// NgramTree.h
class NgramTree {
public:
    NgramTree();
    ~NgramTree();
    void addNgram ( string ngram );
    int getTotalNgramCount();
    bool isComplete();
    bool isFull();
    void generateTree(string fileName, int n);
    // General BST methods
    void inOrderTraversal();
    BinaryNode* search(string ngram);
    bool deleteNgram(string ngram);
    int getHeight(); // we don't use this but it might be helpfull for some purposes

private:
    // properties
    BinaryNode* root;
    // helper methods
    int getTotalNgramCount(BinaryNode* root);
    int getHeight(BinaryNode* root);
    void addNgram( BinaryNode* &root, string ngram);
    bool isFull(BinaryNode* root);
    bool isComplete(BinaryNode* root, int index, int lastNodeIndex);
    BinaryNode* search(BinaryNode* root, string ngram);
    void inOrderTraversal(BinaryNode* root);
    bool deleteNgram(BinaryNode* root, string ngram);
    void processLeftmost(BinaryNode *&root, string& item);
    void destroyTree(BinaryNode *root);

    friend ostream& operator <<(ostream& out, NgramTree& tree );
};