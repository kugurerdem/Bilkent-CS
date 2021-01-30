/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 4
* Description: .cpp file for AVLTree
*/

#include "AVLTree.h"
#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;

// Default constructor
AVLTree::AVLTree(){
    root = NULL;
}

// Destructor
AVLTree::~AVLTree(){
    destroyTree(root);
}    

// method thats adds a word to the AVLTree
void AVLTree::addWord(string word){
    addWord(root, word);
}

// helper method that adds a word
void AVLTree::addWord(BinaryNode*& node, string word ){ 
    if( node == NULL){
        node = new BinaryNode(word);
    } else{
        if( word.compare(node->getItem()) == 0){
            node->setCount(node->getCount() + 1); // increase count/frequiency by 1
        }
        else if( word.compare(node->getItem()) > 0){
            addWord(node->getRightPtr(), word);
            // we should rebalance the whole tree
            node = balance( node);
        } else{
            addWord(node->getLeftPtr(), word);
            // we should rebalance the whole tree
            node = balance( node);
        }
    }
}

// returns the height difference of the right and left node
int AVLTree::getBalance(BinaryNode* root){
    if( root == NULL){
        return 0;
    } else{
        return getHeight( root->getLeftPtr() ) - getHeight( root->getRightPtr() );
    }
}

// method that balances the tree
BinaryNode* AVLTree::balance(BinaryNode* node){
    int balance_factor = getBalance(node);
    if( balance_factor > 1){
        if( getBalance(node->getLeftPtr()) > 0 ){
            // RR rotate
            node = rightRotate( node);
        } else{
            // LR rotate
            node = leftRightRotate( node);
        }
    } else if(balance_factor < -1){
        if( getBalance(node->getRightPtr()) > 0 ){
            // RL rotate
            node = rightLeftRotate( node);
        } else{
            // LL rotate
            node = leftRotate( node);
        }
    }

    return node;
}

// method that left rotates the given node
BinaryNode* AVLTree::leftRotate(BinaryNode* node){
    BinaryNode* child = node->getRightPtr();
    BinaryNode* grandchild = child->getLeftPtr();
    // child->setLeftPtr(NULL);
    node->setRightPtr( grandchild);
    child->setLeftPtr( node);
    return child;
} 

// method that right rotates the given node
BinaryNode* AVLTree::rightRotate(BinaryNode* node){
    BinaryNode* child = node->getLeftPtr();
    BinaryNode* grandchild = child->getRightPtr();
    // child->setRightPtr(NULL);
    node->setLeftPtr( grandchild);
    child->setRightPtr( node);
    return child;
}

// method that left-right rotates the given node
BinaryNode* AVLTree::leftRightRotate(BinaryNode* node){
    BinaryNode* child = node->getLeftPtr();
    node->setLeftPtr( leftRotate(child) );
    return rightRotate( node);
}

// method that right-left rotates the given node
BinaryNode* AVLTree::rightLeftRotate(BinaryNode* node){
    BinaryNode* child = node->getRightPtr();
    node->setRightPtr( rightRotate(child) );
    return leftRotate( node);
}

void AVLTree::generateTree(string fileName){
    // we should delete the tree before generating new one
    destroyTree( root);

    // let's add words in the file into the tree
    ifstream inFile( fileName);
    if( inFile.is_open()){
        // extracting words from the file 
        string word;
        string wordToAdd = "";

        while (inFile >> word) { 
            // we need to seperate the word in to words
            
            for(int i = 0; i < word.length(); i++){
                char ch = tolower( word.at(i));
                if( isalpha(ch) ){
                    wordToAdd = wordToAdd + ch;
                } 

                // add the word so far to the tree if we are at non-alphabetic char 
                // or we are at the and of the string
                if( !isalpha(ch) || i >= word.length()-1){
                    if( wordToAdd != "")
                        addWord( wordToAdd);
                    
                    wordToAdd = "";
                }
            }
        }

        inFile.close();
    }

    // lets write the frequiencies
    ofstream outFile( "wordfreqs");
    if( outFile.is_open() ){
        printWordFrequencies( outFile);
        outFile.close();
    }

    // lets write the statistics
    ofstream outFile2( "statistics");
    if( outFile2.is_open()){
        // print the statistics
        printHeight(outFile2);
        printTotalWordCount(outFile2);
        printMostFrequent(outFile2);
        printLeastFrequent(outFile2);
        printStandartDeviation(outFile2);

        outFile2.close();
    }
}

// prints height to the console
void AVLTree::printHeight(ofstream& outFile){
    outFile << "height of the AVL Tree is : " << getHeight( root) << endl;
}

// prints the # of distinct words to the console
void AVLTree::printTotalWordCount(ofstream& outFile){
    outFile << "total word count is : " << getTotalWordCount( root) << endl;
}

// helper for printWordFrequencies(ofstream)
void AVLTree::printWordFrequencies(ofstream& outFile, BinaryNode* root){
    if( root != NULL){
        printWordFrequencies(outFile, root->getLeftPtr());
        outFile << root->getItem() << " : " << root->getCount() << endl;
        printWordFrequencies(outFile, root->getRightPtr());
    } 
}

// prints the words and their frequiencies to the console
void AVLTree::printWordFrequencies(ofstream& outFile){
    printWordFrequencies(outFile, root);
}

// helper method that returns the node of the most frequent word
BinaryNode* AVLTree::getMostFrequent(BinaryNode* root){
    if( root != NULL){
        // get the left and right tree's most frequent node
        BinaryNode* left = getMostFrequent( root->getLeftPtr() );
        BinaryNode* right = getMostFrequent( root->getRightPtr() );

        // determine the most frequent root
        BinaryNode* mostFreq = root; // by default
        
        // compare the nodes
        if( left != NULL)
            mostFreq = mostFreq->getCount() < left->getCount() ? left : mostFreq;
        if( right != NULL)
            mostFreq = mostFreq->getCount() < right->getCount() ? right : mostFreq;

        return mostFreq;
    }

    return root; // if root is NULL
}

// helper method that returns the node of the least frequent word
BinaryNode* AVLTree::getLeastFrequent(BinaryNode* root){
    if( root != NULL){
        // get the left and right tree's most frequent node
        BinaryNode* left = getLeastFrequent( root->getLeftPtr() );
        BinaryNode* right = getLeastFrequent( root->getRightPtr() );

        // determine the most frequent root
        BinaryNode* leastFreq = root; // by default
        
        // compare the nodes
        if( left != NULL)
            leastFreq = leastFreq->getCount() > left->getCount() ? left : leastFreq;
        if( right != NULL)
            leastFreq = leastFreq->getCount() > right->getCount() ? right : leastFreq;

        return leastFreq;
    }

    return root; // if root is NULL
}

// method that returns the node of the most frequent word
BinaryNode* AVLTree::getMostFrequent(){
    return getMostFrequent( root);
}

// method that returns the node of the least frequent word
BinaryNode* AVLTree::getLeastFrequent(){
    return getLeastFrequent( root);
}

// prints the frequence of the most frequent word
void AVLTree::printMostFrequent(ofstream& outFile){
    // find the most frequent word and print it
    BinaryNode* mostFreq = getMostFrequent();
    outFile << "the most frequent word is " << mostFreq->getItem() << " : " << mostFreq->getCount() << endl;
}

// prints the frequence of the least frequent word
void AVLTree::printLeastFrequent(ofstream& outFile){
    // find the least frequent word and print it
    BinaryNode* leastFreq = getLeastFrequent();
    outFile << "the least frequent word is " << leastFreq->getItem() << " : " << leastFreq->getCount() << endl;
}

// prints the standart deviation of the frequiencies of nodes
void AVLTree::printStandartDeviation(ofstream& outFile){
    outFile << "standart deviation : " << getStandartDeviation() << endl;
}

double AVLTree::getStandartDeviation(){
    double mean = getFrequency() / getTotalWordCount();
    double variance = sumOfVarianceTerms(root, mean) / getTotalWordCount();
    double std_deviation = sqrt( variance);
    return std_deviation;
}

// returns the sum of the terms in the variance
double AVLTree::sumOfVarianceTerms(BinaryNode* root, double mean){
    if( root != NULL){
        return sumOfVarianceTerms(root->getLeftPtr(), mean)  
                + ((root->getCount() - mean) * (root->getCount() - mean))
                + sumOfVarianceTerms(root->getRightPtr(), mean);
    }
    return 0;
}

// AVL tree methods
int AVLTree::getHeight(BinaryNode* root){
    if( root != NULL){
        int leftHeight = getHeight(root->getLeftPtr());
        int rightHeight = getHeight(root->getRightPtr());
        
        if( leftHeight > rightHeight)
            return 1 + leftHeight;
        return 1 + rightHeight;
    }
    return 0;
}

// returns the total sum of frequiencies
int AVLTree::getFrequency(){
    return getFrequency(root);
}

// returns the total sum of frequiencies of the given node
int AVLTree::getFrequency(BinaryNode* root){
    if( root == NULL){
        return 0;
    } else{
        return getFrequency( root->getRightPtr() ) + getFrequency( root->getLeftPtr()) + root->getCount();
    }
}


// Recursive overloaded method that returns the number of total distinct n-grams
int AVLTree::getTotalWordCount(BinaryNode* root){
    if( root == NULL){
        return 0;
    } else{
        return 1 + getTotalWordCount(root->getLeftPtr()) + getTotalWordCount(root->getRightPtr());
    }
}

// Returns the total number of words
int AVLTree::getTotalWordCount(){
    return getTotalWordCount(root);
}

// destroys the tree
void AVLTree::destroyTree(BinaryNode*& root){
    if( root != NULL){
        destroyTree(root->getLeftPtr());
        destroyTree(root->getRightPtr());
        delete root;
        root = NULL;
    }
}

