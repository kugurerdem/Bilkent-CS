/*
* Title: Heaps
* Author: Uğur Erdem Seyfi
* ID: 12801744
* Assignment: 3
* Description: Header file for the Heap
*/
#include <iostream>
using namespace std;

#define MAX_HEAP_SIZE 15000

class Heap{
public:
    Heap();
    Heap(int* arr, int heapSize, int& keyComp);
    ~Heap();
    
    void insert(const int a);
    int maximum();
    int popMaximum();
    int popMaximum(int& keyComp);
private:
    int* items;
    int size;
    // int HEAP_SIZE;
    int keyComp;

    void heapRebuild(int index, int& keyComp);
};

