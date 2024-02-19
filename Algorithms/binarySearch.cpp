// Binary Search in C++

#include <iostream>
using namespace std;

int binarySearch(int numbers[], int size, int low, int high) {
  
	// Repeat until the pointers low and high meet each other
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (numbers[mid] == size)
      return mid;

    if (numbers[mid] < size)
      low = mid + 1;

    else
      high = mid - 1;
  }

  return -1;
}

int main(void) {
  int size = 10;
  // defining array of size "size" 
  int numbers[size]; 

    // using loop to move to every array element and then 
    // using either cin to insert the value given by the 
    // user to the array element 
    for (int i = 0; i < size; i++) { 
        cout << "Enter a number: "; 
        cin >> numbers[i]; 
    } 
  
    // Print the array elements 
    cout << "The array elements are: "; 
    for (int i = 0; i < size; i++) { 
        cout << numbers[i] << " "; 
    } 
  int x;
  int n = sizeof(numbers) / sizeof(numbers[0]);

    cout << "\nEnter the number to search for: ";
    cin >> x;

  int result = binarySearch(numbers, x, 0, n - 1);

  if (result == -1)
    printf("Not found");
  else
    printf("Element is found at index %d", result);
}


/*

Expected Output:

// these are sample values to enter into the array

Enter a number: 1
Enter a number: 2
Enter a number: 3
Enter a number: 4
Enter a number: 5
Enter a number: 6
Enter a number: 7
Enter a number: 8
Enter a number: 9
Enter a number: 10
The array elements are: 1 2 3 4 5 6 7 8 9 10 
Enter the number to search for: 5
Element is found at index 4

*/