#include <iostream>
#include <ctime>

using namespace std;

int linearSearch(int* arr, int LEN, int value){
    for(int i = 0; i < LEN; i++){
        if( arr[i] == value)
            return i;
    }

    return -1;
}

int binarySearch(int* arr, int LEN, int value){
    int left = 0;
    int right = LEN - 1;

    while( left < right){
        int pivot = (left + right) / 2;

        if( arr[pivot] > value)
            left = pivot + 1;
        else if( arr[pivot] < value)
            right = pivot - 1;
        else
            return pivot;
    }

    return -1;
}

void averageTime(int* arr, int LEN, int val){
        // LINEAR SEARCH
        int repeat = 100;
        //Store the starting time
        double duration;
        clock_t startTime = clock();
        
        for(int i = 0; i < repeat; i++)
            linearSearch(arr, LEN, val);
        
        //Compute the number of seconds that passed since the starting time
        duration = 1000 * double( clock() - startTime ) / CLOCKS_PER_SEC;
        duration = duration / repeat;
        cout << "    LinearSearch took " << duration << " milliseconds." << endl;

        // BINARY SEARCH

        //Store the starting time
        startTime = clock();
        
        for(int i = 0; i < repeat; i++)
            binarySearch(arr, LEN, val);
        
        //Compute the number of seconds that passed since the starting time
        duration = 1000 * double( clock() - startTime ) / CLOCKS_PER_SEC;
        duration = duration / repeat;
        cout << "    binarySearch took " << duration << " milliseconds." << endl;
}

int main() 
{
    int LEN = 1;
    
    while( LEN <= 100000000){
        int* arr = new int[LEN];

        for(int i = 0; i < LEN; i++){
            arr[i] = i;
        }

        cout << "input size is " << LEN << endl;

        // (i) The key is close to the beginning
        cout << "  (i) The key is close to the beginning: " << endl;
        averageTime(arr, LEN, 1);

        // (ii) The key is around the middle
        cout << "  (ii) The key is around the middle: " << endl;
        averageTime(arr, LEN, LEN / 2);

        // (iii) The key is close to the end
        cout << "  (iii) The key is close to the end: " << endl;
        averageTime(arr, LEN, LEN - 1);

        // (iv) The key is not in the list
        cout << "  (iv) The key is not in the list: " << endl;
        averageTime(arr, LEN, -1);

        delete [] arr;
        LEN = LEN * 10;
    }

    cout << "Hello, World!";
    return 0;
}