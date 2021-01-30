/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 2
* Description: header file for BinaryNode
*/

#include <iostream>
#include <string>
using namespace std;

// BinaryNode.h
class BinaryNode
{
private :
    string item; // Data portion
    BinaryNode* leftPtr; // Pointer to left child
    BinaryNode* rightPtr; // Pointer to right child
    int count;
public :
    BinaryNode();
    BinaryNode( const string& anItem);
    BinaryNode( const string& anItem,
                BinaryNode* leftP,
                BinaryNode* rightP, int cnt);
    
    void setItem( const string& anItem);
    string getItem() const;
    bool isLeaf() const;
    BinaryNode*& getLeftPtr();
    BinaryNode*& getRightPtr();
    int getCount();
    void setLeftPtr(BinaryNode* leftPtr);
    void setRightPtr(BinaryNode* rightPtr);
    void setCount(int cnt);
}; // end BinaryNode