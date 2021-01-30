#include <iostream>
#include <string>
#include "AVLTree.h"

using namespace std;

int main (int argc, char **argv) {
    string file_name = argv[1];

    AVLTree* tree = new AVLTree();
    tree->generateTree (file_name); 
    
    delete tree;

    return 0;
}