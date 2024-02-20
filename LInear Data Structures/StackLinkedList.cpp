// stack using singly linked list

#include <bits/stdc++.h>
using namespace std;

// creating a linked list;
class Node {
public:
	int data;
	Node* link;

	// Constructor
	Node(int n)
	{
		this->data = n;
		this->link = NULL;
	}
};

class Stack {
	Node* top;

public:
	Stack() { top = NULL; }

	void push(int data)
	{

		// Create new node temp and allocate memory in heap
		Node* temp = new Node(data);

		// Check if stack (heap) is full.
		// Then inserting an element would
		// lead to stack overflow
		if (!temp) {
			cout << "\nStack Overflow";
			exit();
		}

		// Initialize data into temp data field
		temp->data = data;

		// Put top pointer reference into temp link
		temp->link = top;

		// Make temp as top of Stack
		top = temp;
	}

	// check if Stack is empty
	bool isEmpty()
	{
		// If top is NULL it means that
		// there are no elements are in stack
		return top == NULL;
	}

	// remove element from Stack
	void pop()
	{
		Node* temp;

		// Check for stack underflow
		if (top == NULL) {
			cout << "\nStack Underflow" << endl;
			exit();
		}
		else {

			// Assign top to temp
			temp = top;

			// Assign second node to top
			top = top->link;

			// This will automatically destroy
			// the link between first node and second node

			// Release memory of top node
			// i.e delete the node
			free(temp);
		}
	}

	// print all elements in Stack
	void display()
	{
		Node* temp;

		// Check for stack underflow
		if (top == NULL) {
			cout << "\nStack Underflow";
		}
		else {
			temp = top;
			while (temp != NULL) {

				// Print node data
				cout << temp->data;

				// Assign temp link to temp
				temp = temp->link;
				if (temp != NULL)
					cout << " -> ";
			}
		}
	}

	    void exit() {
        cout << "Hope to see you again soon!" << endl;
    }
};

// main driver method
int main()
{
	Stack userStack;

	int choice;
	int value;
	
	do {
		cout << "\nSelect an option:\n1. Enter element to Stack \n2. Pop the element from Stack \n3. Display all the elements in the Stack \n0. Exit\n";
		cin >> choice;

		switch (choice) {
			case 0:
				userStack.exit();
				break;
			case 1:
				cout << "Enter the number you want to enter into Stack ";
				cin >> value;
				userStack.push(value);
				break;
				
			case 2:
				userStack.pop();
				break;

			case 3:
				userStack.display();
                break;

			default:
				cout << "Please make another choice\n";
				break;
			}
	} 
	
	while (choice != 0);
		return 0;
}
