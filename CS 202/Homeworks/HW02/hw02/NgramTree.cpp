/**
* Title: Trees
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 2
* Description: .cpp file for NGramTree
*/

#include "NgramTree.h"
#include <fstream>

// NgramTree.cpp

// Default constructor
NgramTree::NgramTree(){ 
    root = NULL;
}

// Method that destroys all of the existent nodes in the tree
void NgramTree::destroyTree(BinaryNode *root){
    if( root != NULL){
        destroyTree( root->getLeftPtr() );
        destroyTree( root->getRightPtr());
        root->getLeftPtr() = NULL;
        root->getRightPtr() = NULL;
        delete root;
    }
}

// Default Destructor
NgramTree::~NgramTree(){ 
    destroyTree(root);
}

// Method that adds n-gram to the tree
void NgramTree::addNgram ( string ngram ){ 
    addNgram(root, ngram);
}

// Recursive overloaded method that adds n-gram to the tree
void NgramTree::addNgram (BinaryNode* &root, string ngram ){ 
    if( root == NULL){
        root = new BinaryNode(ngram);
    } else{
        if( ngram.compare(root->getItem()) == 0){
            root->setCount(root->getCount() + 1); // increase count by 1
        }
        else if( ngram.compare(root->getItem()) > 0){
            addNgram(root->getRightPtr(), ngram);
        } else{
            addNgram(root->getLeftPtr(), ngram);
        }
    }
}

// Method that returns the number of total distinct n-grams
int NgramTree::getTotalNgramCount(){
    getTotalNgramCount(root);
}

// Recursive overloaded method that returns the number of total distinct n-grams
int NgramTree::getTotalNgramCount(BinaryNode* root){
    if( root == NULL){
        return 0;
    } else{
        return 1 + getTotalNgramCount(root->getLeftPtr()) + getTotalNgramCount(root->getRightPtr());
    }
}

// Method that returns the height of the tree
int NgramTree::getHeight(){
    return getHeight(root);
}

// Recursive overloaded method that returns the height of the tree
int NgramTree::getHeight(BinaryNode* root){
    if( root != NULL){
        int leftHeight = getHeight(root->getLeftPtr());
        int rightHeight = getHeight(root->getRightPtr());
        
        if( leftHeight > rightHeight)
            return 1 + leftHeight;
        return 1 + rightHeight;
    }
    return 0;
}

// Method that deletes the node of the given n-gram
bool NgramTree::deleteNgram(string ngram){
   deleteNgram(root, ngram);
}

// Overloaded recursive method that deletes the node of the given n-gram
bool NgramTree::deleteNgram(BinaryNode* root, string ngram){
    if( root == NULL){
        return false;
    } else{
        string item = root->getItem();
        // if root is the node to be deleted
        if( item.compare(ngram) == 0){
            // delete the node
            BinaryNode* delPtr;

            // case 1: root is leaf
            if( root->isLeaf() ){
                delete root;
                root = NULL;
            } 
            
            // case 2: no left child
            else if( root->getLeftPtr() == NULL){
                delPtr = root;
                root = root->getRightPtr();
                delPtr->getRightPtr() = NULL;
                delete delPtr;
            } 
            
            // case 3: no right child
            else if( root->getRightPtr() == NULL){
                delPtr = root;
                root = root->getLeftPtr();
                delPtr->getLeftPtr() = NULL;
                delete delPtr;
            } 
            
            // case 4: has two children
            else{
                string replacement_item;
                processLeftmost(root->getRightPtr(), replacement_item);
                root->setItem( replacement_item);
            }

        } else if( item.compare(ngram) > 0){
            deleteNgram(root->getLeftPtr(), ngram);
        } else{
            deleteNgram(root->getRightPtr(), ngram);
        }
    }
}

// Method that gives (retrieves) the item of the leftMost element in the tree
void NgramTree::processLeftmost(BinaryNode *&root, string& item){
    if( root->getLeftPtr() == NULL){
        item = root->getItem();
        BinaryNode *delPtr = root;
        root = root->getRightPtr();
        delPtr->getRightPtr() = NULL; // defense
        delete delPtr;
    } else{
        processLeftmost(root->getLeftPtr(), item);
    }
}  

// Method that returns whether the tree is complete or not
bool NgramTree::isComplete(){ 
    int lastNodeIndex = getTotalNgramCount() - 1;
    isComplete(root, 0, lastNodeIndex);
}

// Method that returns whether the tree is complete or not
bool NgramTree::isComplete(BinaryNode* root, int index, int lastNodeIndex){
    if( root != NULL){
        if(index > lastNodeIndex){
           return false; 
        } 

        return isComplete(root->getLeftPtr(), 2*index + 1, lastNodeIndex) &&
                isComplete(root->getRightPtr(), 2*index + 2, lastNodeIndex);
    }
    return true;
}

// Method that returns whether the tree is full or not
bool NgramTree::isFull(){ 
    return isFull(root);
}

// Method that returns whether the tree is full or not
bool NgramTree::isFull(BinaryNode* root){
    if(root != NULL){
        if( ! root->isLeaf()){
            if( (root->getLeftPtr() != NULL) && (root->getRightPtr() != NULL) ){
                return isFull(root->getLeftPtr()) && isFull(root->getRightPtr());
            }
            return false;
        } 
        return true;
    }
    return true;
}

// Method that generates the tree given filename and n where n is the "n" in "n-gram"
void NgramTree::generateTree(string fileName, int n){ 

    // we copy the chars of fileName string into array of chars flName
    char* flName = new char[fileName.length()];
    for(int i = 0; i < fileName.length(); i++){
        flName[i] = fileName.at(i);
    }

    // scanning the file into the text variable
    string line;
    string text;
    ifstream file (flName);
    if (file.is_open()){
        while ( getline(file,line) ){
            text = text + line + '\n';
        }
        file.close();
        delete [] flName; // we don't want memory leaks
    }

    // adding ngrams from the text obtained by the file
    string word;
    char delimiter1 = ' '; // for seperating words
    char delimiter2 = '\n'; // for linux
    char delimiter3 = '\r'; // for mac
    for(int i = 0; i < text.length(); i++){
        if( text.at(i) == delimiter1 || text.at(i) == delimiter2 || text.at(i) == delimiter3){
            // insert the possible ngrams in the word
            for(int j = 0; j < word.length(); j++){
                if(n <= word.length() - j){
                    addNgram( word.substr(j, n));
                }
            }
            word = "";
        } else{
            word = word + text.at(i);
        }
    }
}

// Method that traverses the array in order
void NgramTree::inOrderTraversal(){
    inOrderTraversal(root);
}

// Recursive overloaded method that traverses the array in order
void NgramTree::inOrderTraversal(BinaryNode* root){
    if( root != NULL){
        inOrderTraversal(root->getLeftPtr());
        cout << "\"" << root->getItem() << "\" appears " << root->getCount() << " times." << "\n";
        inOrderTraversal(root->getRightPtr());
    }
}

// Method that searches and returns the node associated with the given ngram
BinaryNode* NgramTree::search(string ngram){
    return search(root, ngram);
}

// Recursive overloaded method that searches and returns the node associated with the given ngram
BinaryNode* NgramTree::search(BinaryNode* root, string ngram){
    if(root != NULL){
        if(root->getItem().compare(ngram) == 0){
            return root;
        } else if( root->getItem().compare(ngram) > 0){
            return search(root->getLeftPtr(), ngram);
        } else{
            return search(root->getRightPtr(), ngram);
        }
    }

    return NULL;
}

// Overloading the << operator.
ostream& operator<<(ostream& out, NgramTree& tree ){ 
    tree.inOrderTraversal();
    return out;
}

