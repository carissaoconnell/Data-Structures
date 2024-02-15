#include <iostream>
using namespace std;

int main(){
    int size, value;

    cout << "Enter the number of Nodes for the Linked List: ";
    cin >> size;

    for (int i = 0; i < size; i++){
        cin >> value;
        addNode(value);
    }
    displayNode();
}

struct Node{
    int data;
    int nodeNumber;
    Node *next;
};

Node *nodeHead=NULL;

void addNode (int num);
void displayNode();
 
void addNode(int num){
    Node *tail = nodeHead;
    Node *nodePtr = new Node;
    nodePtr->data = num;
    nodePtr->next = NULL;

    if (nodeHead == NULL){
        nodeHead = nodePtr;
    }
    else{
        while(tail->next != NULL){
            tail = tail->next;
        }
        tail->next = nodePtr;
    }
}

void displayNode(){
    Node *nodeTemp = new Node;
    nodeTemp = nodeHead;
    
    cout<<"The linked list: ";
    while(nodeTemp != NULL){
        cout << nodeTemp->data << " ";
        nodeTemp = nodeTemp->next;
    }
}