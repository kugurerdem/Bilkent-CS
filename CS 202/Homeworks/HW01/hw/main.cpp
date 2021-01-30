/**
* Title: Algorithm Efficiency and Sorting
* Author: Uğur Erdem Seyfi
* ID: 21801744
* Assignment: 1
* Mail file for testing the sorting methods defined in sorting.cpp.
*/

#include <iostream> 
using namespace std;

#include "sorting.h"

int main() {

    int sizeConstant = 25000;
    // EXPERIMENT FOR RANDOMLY GENERATED ARRAYS
    cout << "\n !> EXPERIMENT FOR RANDOMLY GENERATED ARRAYS <! \n";
    for(int j = 1; j <= 5; j++){
        int size = j * sizeConstant;

        int* array_1 = new int[size];
        int* array_2 = new int[size];
        int* array_3 = new int[size];

        for(int i = 0; i < size; i++){
            int value = rand();
            array_1[i] = value;
            array_2[i] = value;
            array_3[i] = value;
        }
        
        unsigned long long  compC_1 = 0; 
        unsigned long long  compC_2 = 0;
        unsigned long long  compC_3 = 0;
        unsigned long long  moveC_1 = 0;
        unsigned long long  moveC_2 = 0;
        unsigned long long  moveC_3 = 0;

        clock_t clock_1 = clock();
        insertionSort(array_1, size, compC_1, moveC_1);
        clock_1 = clock() - clock_1;

        clock_t clock_2 = clock();
        mergeSort(array_2, size, compC_2, moveC_2);
        clock_2 = clock() - clock_2;

        clock_t clock_3 = clock();
        quickSort(array_3, size, compC_3, moveC_3);
        clock_3 = clock() - clock_3;

        cout << "\n !!! EXPERIMENT " << j << " WITH SIZE OF " << size << "!!! \n";
        cout << "\n - INSERTION SORT - \n";
        cout << "Comparison count: " << compC_1 << "\nMovement count:   " << moveC_1;
        cout << "\nTime passed: " << ((float) clock_1 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - MERGE SORT - \n";
        cout << "Comparison count: " << compC_2 << "\nMovement count:   " << moveC_2;
        cout << "\nTime passed: " << ((float) clock_2 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - QUICK SORT - \n";
        cout << "Comparison count: " << compC_3 << "\nMovement count:   " << moveC_3;
        cout << "\nTime passed: " << ((float) clock_3 / CLOCKS_PER_SEC) << " seconds.";


        // we don't want memory leaks
        delete [] array_1;
        delete [] array_2;
        delete [] array_3;
    }

    // EXPERIMENT FOR DESCENDING ARRAYS
    cout << "\n !> EXPERIMENT FOR DESCENDING ARRAYS <! \n";
    for(int j = 1; j <= 5; j++){
        int size = j * sizeConstant;

        int* array_1 = new int[size];
        int* array_2 = new int[size];
        int* array_3 = new int[size];

        for(int i = 0; i < size; i++){
            int value = size - i;
            array_1[i] = value;
            array_2[i] = value;
            array_3[i] = value;
        }

        unsigned long long  compC_1 = 0; 
        unsigned long long  compC_2 = 0;
        unsigned long long  compC_3 = 0;
        unsigned long long  moveC_1 = 0;
        unsigned long long  moveC_2 = 0;
        unsigned long long  moveC_3 = 0;

                clock_t clock_1 = clock();
        insertionSort(array_1, size, compC_1, moveC_1);
        clock_1 = clock() - clock_1;

        clock_t clock_2 = clock();
        mergeSort(array_2, size, compC_2, moveC_2);
        clock_2 = clock() - clock_2;

        clock_t clock_3 = clock();
        quickSort(array_3, size, compC_3, moveC_3);
        clock_3 = clock() - clock_3;

        cout << "\n !!! EXPERIMENT " << j << " WITH SIZE OF " << size << "!!! \n";
        cout << "\n - INSERTION SORT - \n";
        cout << "Comparison count: " << compC_1 << "\nMovement count:   " << moveC_1;
        cout << "\nTime passed: " << ((float) clock_1 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - MERGE SORT - \n";
        cout << "Comparison count: " << compC_2 << "\nMovement count:   " << moveC_2;
        cout << "\nTime passed: " << ((float) clock_2 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - QUICK SORT - \n";
        cout << "Comparison count: " << compC_3 << "\nMovement count:   " << moveC_3;
        cout << "\nTime passed: " << ((float) clock_3 / CLOCKS_PER_SEC) << " seconds.";


        // we don't want memory leaks
        delete [] array_1;
        delete [] array_2;
        delete [] array_3;
    }

    // EXPERIMENT FOR ASCENDING ARRAYS
    cout << "\n !> EXPERIMENT FOR ASCENDING ARRAYS <! \n";
    for(int j = 1; j <= 5; j++){
        int size = j * sizeConstant;

        int* array_1 = new int[size];
        int* array_2 = new int[size];
        int* array_3 = new int[size];

        for(int i = 0; i < size; i++){
            int value = i;
            array_1[i] = value;
            array_2[i] = value;
            array_3[i] = value;
        }

        unsigned long long  compC_1 = 0; 
        unsigned long long  compC_2 = 0;
        unsigned long long  compC_3 = 0;
        unsigned long long  moveC_1 = 0;
        unsigned long long  moveC_2 = 0;
        unsigned long long  moveC_3 = 0;

                clock_t clock_1 = clock();
        insertionSort(array_1, size, compC_1, moveC_1);
        clock_1 = clock() - clock_1;

        clock_t clock_2 = clock();
        mergeSort(array_2, size, compC_2, moveC_2);
        clock_2 = clock() - clock_2;

        clock_t clock_3 = clock();
        quickSort(array_3, size, compC_3, moveC_3);
        clock_3 = clock() - clock_3;

        cout << "\n !!! EXPERIMENT " << j << " WITH SIZE OF " << size << "!!! \n";
        cout << "\n - INSERTION SORT - \n";
        cout << "Comparison count: " << compC_1 << "\nMovement count:   " << moveC_1;
        cout << "\nTime passed: " << ((float) clock_1 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - MERGE SORT - \n";
        cout << "Comparison count: " << compC_2 << "\nMovement count:   " << moveC_2;
        cout << "\nTime passed: " << ((float) clock_2 / CLOCKS_PER_SEC) << " seconds.";
        cout << "\n - QUICK SORT - \n";
        cout << "Comparison count: " << compC_3 << "\nMovement count:   " << moveC_3;
        cout << "\nTime passed: " << ((float) clock_3 / CLOCKS_PER_SEC) << " seconds.";

        // we don't want memory leaks
        delete [] array_1;
        delete [] array_2;
        delete [] array_3;
    }

    return 0;
}