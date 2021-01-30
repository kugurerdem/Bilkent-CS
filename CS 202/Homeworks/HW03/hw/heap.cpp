/*
* Title: Heaps
* Author: Uğur Erdem Seyfi
* ID: 12801744
* Assignment: 3
* Description: .cpp file for the Heap
*/

#include "heap.h"

// Default constructor for the heap
Heap::Heap(){
    // HEAP_SIZE = 50;
    size = 0;
    keyComp = 0;
    items = new int[MAX_HEAP_SIZE];
}

// Second constructor for the heap with an array to heapifize, the size of the array, and number of keyComp
Heap::Heap(int* arr, int heapSize, int& keyComp){
    size = heapSize;
    // determine the max_size
    int max_size = MAX_HEAP_SIZE > heapSize ? MAX_HEAP_SIZE : heapSize;
    items = new int[max_size];
    
    // copy the array into the items
    for(int i = 0; i < size; i++){
        items[i] = arr[i];
    }

    // rebuild the whole array
    for(int i = (size-1) / 2; i >= 0; i--){
        heapRebuild(i , keyComp);
    }
}

// inserting an element a into the array
Heap::~Heap(){
    delete[] items;
}

void Heap::insert(const int a){
    // add the item to the end of the heap
    items[size] = a;
    size++;

    // put the new item into its proper place
    int index = size - 1;
    int parent = (index - 1) / 2;
    while( parent >= 0 && items[index] > items[parent] ){
        // swap the parrent and inserted item
        int tmp = items[index];
        items[index] = items[parent];
        items[parent] = tmp;

        // update their indexes
        index = parent;
        parent = (index - 1)/2;
    }
}

// returns the maximum element
int Heap::maximum(){
    return items[0];
}

// pops the maximum element
int Heap::popMaximum(){
    int keyComp; // we need to pass something to the popMaximum
    return popMaximum( keyComp);
}

// pops the maximum element while counting keyComp
int Heap::popMaximum(int& keyComp){
    // check the size

    // remove the item
    int itemToPop = items[0];
    items[0] = items[--size];

    // rebuild the heap
    heapRebuild(0, keyComp);
    return itemToPop;
}

// this method rebuilds the heap from the given index and also counts the # of comparisons
void Heap::heapRebuild(int index, int& keyComp) {   
	int child = 2 * index + 1; 	// index of root's left child 
	if ( child < size ) {		
        // if right child exists, choose the child as the maximum one
        child = child + 1 < size && items[child + 1] > items[child] ? child + 1 : child;

		// If root’s item is smaller than larger child, swap values
		if ( items[index] < items[child] ) {
			int temp = items[index];
			items[index] = items[child];
			items[child] = temp;

			// transform the new subtree into a heap
			heapRebuild(child, keyComp);
		}

        keyComp += 1;
    }

    keyComp += 1;
}