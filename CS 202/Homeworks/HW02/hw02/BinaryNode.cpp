/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 2
* Description: .cpp file for BinaryNode
*/

#include "BinaryNode.h"

// BINARY NODE FOR TREE
BinaryNode::BinaryNode(){
    item;
    leftPtr = NULL;
    rightPtr = NULL;
    count = 0;
}

BinaryNode::BinaryNode( const string& anItem){
    item = anItem;
    leftPtr = NULL;
    rightPtr = NULL;
    count = 1;
}

BinaryNode::BinaryNode( const string& anItem, BinaryNode* leftP, BinaryNode* rightP, int cnt){
    item = anItem;
    leftPtr = leftP;
    rightPtr = rightP;
    count = cnt;
}
    
void BinaryNode::setItem( const string& anItem){ 
    item = anItem;
}

string BinaryNode::getItem() const{
    return item;
}

bool BinaryNode::isLeaf() const{
    return (leftPtr == NULL) && (rightPtr == NULL);
}

BinaryNode*& BinaryNode::getLeftPtr(){
    return leftPtr;
}

BinaryNode*& BinaryNode::getRightPtr(){
    return rightPtr;
}

int BinaryNode::getCount(){
    return count;
}

void BinaryNode::setLeftPtr(BinaryNode* leftP){
    leftPtr = leftP;
}
void BinaryNode::setRightPtr(BinaryNode* rightP){
    rightPtr = rightP;
}

void BinaryNode::setCount(int cnt){
    count = cnt;
}