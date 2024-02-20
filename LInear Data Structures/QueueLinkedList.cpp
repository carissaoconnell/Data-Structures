#include <iostream>
using namespace std;

struct node {
   int data;
   // declare the node to hold the data of the first value and the address of the next node
   struct node *next;
};

struct node* front = NULL;
struct node* rear = NULL;
struct node* temp;

void insertElement() {
   int number;
   cout << "Enter the value for the queue: " << endl;
   cin >> number;
   if (rear == NULL) {
      // the malloc function is used to allocate memory for the nodes dynamically 
      rear = (struct node *)malloc(sizeof(struct node));
      rear->next = NULL;
      rear->data = number;
      front = rear;
   } 
   else {
      temp = (struct node *)malloc(sizeof(struct node));
      rear->next = temp;
      temp->data = number;
      temp->next = NULL;
      rear = temp;
   }
}

void deleteElement() {
   temp = front;
   if (front == NULL) {
      cout << "Underflow" << endl;
      return;
   }

   else
    if (temp->next != NULL) {
      temp = temp->next;
      cout << "Element deleted from queue is: " << front->data << endl;
      free(front);
      front = temp;
   } 
    else {
      cout << "Element deleted from queue is: " << front->data << endl;
      free(front);
      front = NULL;
      rear = NULL;
   }
}

void displayQueue() {
   temp = front;
   if ((front == NULL) && (rear == NULL)) {
      cout << "Queue is empty" << endl;
      return;
   }
   cout << "Elements in the Queue are: ";
   while (temp != NULL) {
      cout << temp->data << " ";
      temp = temp->next;
   }
   cout << endl;
}


int main() {
   int choice;

   
   do {
      cout << "1) Insert element to queue" << endl;
      cout << "2) Delete element from queue" << endl;
      cout << "3) Display all the elements of queue" << endl;
      cout << "0) Exit" << endl;

      cout << "Enter your choice: "<<endl;
      cin >> choice;
      switch (choice) {
         case 0:
            break;
         case 1: 
            insertElement();
            break;

         case 2: 
            deleteElement();
            break;

         case 3: 
            displayQueue();
            break;

         default: cout << "Please enter a choice between 1 - 3 or 0 to exit" << endl;
      }
   } 
   
   while(choice != 0);
   
   return 0;
}