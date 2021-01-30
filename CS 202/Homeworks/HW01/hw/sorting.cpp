/**
* Title: Algorithm Efficiency and Sorting
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 1
* Sorting methods
*/

#include "sorting.h"
#include <iostream> 


void insertionSort( int* arr, const int size, unsigned long long& compCount, unsigned long long& moveCount ){
    moveCount += 1; // for int i = 1 in the for loop
    for(int i = 1; i < size; i++){
        // for i++, moveCount: |
        // for "i < size", compCount: |

        int val = arr[i]; // moveCount: ||
        int location = i - 1; // moveCount: |||
        while( arr[location] > val && location >= 0){
            arr[location + 1] = arr[location]; // moveCount: |
            location--; // moveCount: ||

            moveCount += 2;
            // for two comparisons in while loop compCount: ||
            compCount += 2;
        }

        arr[location + 1] = val; // moveCount: ||||

        moveCount += 4; 
        compCount += 1;
    }
}

// merges the array, helper method for mergeSort.
void merge( int* arr, int size, int mid, unsigned long long& compCount, unsigned long long& moveCount){
    int tmp_arr[size];

    int index_1 = 0;
    int last_1 = mid;
    int index_2 = mid + 1;
    int last_2 = size - 1;

    int index = 0;

    moveCount += 5;

    // while left is not empty and right is not empty
    while(  index_1 <= last_1 && index_2 <= last_2){
        if( arr[index_1] < arr[index_2]){
            tmp_arr[index] = arr[index_1];
            index_1++;
        } else{
            tmp_arr[index] = arr[index_2];
            index_2++;
        }

        index++;

        moveCount += 3;
        compCount += 3;
    }

    // while left is not empty
    while( index_1 <= last_1){
        tmp_arr[index] = arr[index_1];
        index_1++;

        moveCount += 2;
        compCount += 1;
    }
    
    // while right is not empty
    while( index_2 <= last_2){
        tmp_arr[index] = arr[index_2];
        index_2++;

        moveCount += 2;
        compCount += 1;
    }

    // fix the array
    for(int i = 0; i < size; i++){
        arr[i] = tmp_arr[i];

        moveCount += 2; // for i++ and assignment in the loop
        compCount += 1;  // for "i < size ""
    }

    // we don't want memory leaks
    // delete [] tmp_arr;
}


void mergeSort( int* arr, const int size, unsigned long long& compCount, unsigned long long& moveCount){
    if(size > 1){
        int p = 0;
        int r = size - 1;
        int mid = (p+r) / 2;

        mergeSort(arr, mid + 1, compCount, moveCount);
        mergeSort((arr + mid + 1), size - (mid + 1), compCount, moveCount);

        // merge
        merge(arr, size, mid, compCount, moveCount);

        moveCount += 3;
    }
    compCount += 1;
}       

// Method that swaps the value of given two integer variables.
void swap( int& x, int& y ) {
    int temp = x;
    x = y;
    y = temp;
}

// A helper method that is used in quicksort
void partition( int* arr, const int size, int& pivotNo, unsigned long long& compCount, unsigned long long& moveCount){
    pivotNo = 0;
    int pivot = arr[pivotNo];
    int i = 0; // this stands for the index of the last element in the S1
    
    // j stands for the index of the item that is unknown yet
    int j = i + 1;
    
    while(j < size){
        if( arr[j] < pivot ){
            i = i + 1;
            swap(arr[j], arr[i]); // +3 to moveCount

            moveCount += 4;
        }
        j = j + 1;

        moveCount += 1;
        compCount += 2;
    }

    // placing the pivot to its correct position
    swap( arr[0], arr[i]);
    pivotNo = i;

    moveCount += 8;
}


void quickSort( int* arr, const int size, unsigned long long& compCount, unsigned long long& moveCount){
    // in my implementation, lower index is always considered 0
    // since we sublist the array using pointer arithmetic.
    if( size > 1){
        // create a pivot
        int pivotNo;

        // partition
        partition(arr, size, pivotNo, compCount, moveCount);

        // recursion
        
        quickSort(arr, pivotNo, compCount, moveCount);
        quickSort( (arr + pivotNo + 1), size - (pivotNo + 1), compCount , moveCount);

        moveCount += 1;
    }

    compCount += 1;
}



