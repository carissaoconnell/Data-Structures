/* Check the string to see if it is a Palindrome using Recursion */

#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

// function to check if the string is a Palindrome
// take in the string and check the first and last index of each character in the string
int isPalindrome(string str, int firstIndex, int lastIndex)
{
     // if the first and last character are not the same, check each character in the string except the first and last characters
    if (firstIndex < lastIndex + 1) {  
        firstIndex++;
        lastIndex--; 
        return isPalindrome(str, ++firstIndex, --lastIndex);  
    }

    // if the first and last character are the same, return 1
    if (firstIndex == lastIndex) {
        return 1;
    }

    // if the first and last character are not the same, return 0
    if (str[firstIndex] != str[lastIndex]) {
        return 0;
    }

    return 1;

}


int main()
{
    vector<string> userString; // create an empty vector of string
    string data; // string variable to store the user's word

    cout << "Enter 10 string values: "; // prompt the user
        for(int numElements = 0; numElements < 10; numElements++) { // allow for 10 elements to be input into the vector
            cin >> data; // take in user input and assign it to the variable data
            userString.push_back(data); // insert the new element to the end of the vector; after the last element
        }

    cout << "\n";

    // check each character in each string entered into the vector through isPalindrome
    for(int i = 0; i < userString.size(); i++) {
        // iterate thorugh each of the characters from the string the user input to the vector and check to see if they match
        // check the first and last character of the string through isPalindrome
       if(isPalindrome(userString.at(i),0,userString.at(i).length()-1)) {
           cout << userString.at(i) << " is a Palindrome.\n"; // display message if isPalindrome returns 1
       }

       else {
           cout << userString.at(i) << " is not a Palindrome.\n"; // display message if isPalindrome returns 0
       }
    }
    return 0;
}
