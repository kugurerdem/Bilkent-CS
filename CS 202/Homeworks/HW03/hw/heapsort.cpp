/*
* Title: Heaps
* Author: Uğur Erdem Seyfi
* ID: 12801744
* Assignment: 3
* Description: .cpp file for the Heap
*/

#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib> 
#include "heap.h"

using namespace std;

// heapsort
void heapSort(int* arr, int size, int& keyComp){
    Heap h(arr, size, keyComp);

    for(int last = size - 1; last >= 0; last--){
        arr[last] = h.popMaximum( keyComp);
        keyComp += 1;
    }
}

// main
int main( int argc, char** argv ) {
    // Getting the input/output file names
    char* inputFileName = argv[ 1 ];
    char* outputFileName = argv[ 2 ];

    // Lets create the array
    int arr[MAX_HEAP_SIZE];
    int size = 0;
    int keyComp = 0;

    ifstream inputFile(inputFileName);
    if (inputFile.is_open() ) {
        // iterate over all of the integers
        int index = 0;
        int num;
        while( inputFile >> num) {
            if (size < MAX_HEAP_SIZE){
                arr[index++] = num;
                size++;
            }
        }
        // Close the file
        inputFile.close();
    }
    // sort the array
    heapSort(arr, size, keyComp);

    // process the output file
    ofstream outputFile(outputFileName);
    if (outputFile.is_open() ) {
        // print the results
        outputFile << "Number of key comparisons: " << keyComp << endl;
        outputFile << "Sorted Array Elements: "<< endl;
        for ( int i = 0; i < size; i++ ){
            outputFile << arr[i] << endl;
            // cout << arr[i] << endl;
        }
        outputFile.close();
    }

    return 0;
}