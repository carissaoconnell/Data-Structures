// c++ program for singly linked list

#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;

// declare node
struct node
{
    int info;
    struct node *next;
}*start;
 
// declare class constructor with the methods in the class
class singleLinkedList
{
    public:
        node* createNode(int);
        void insertAtHead();
        void insertAtTail(); 
        void insertAtPosition();
        void sort();
        void deleteAtPosition();
        void updateNode();
        void search();
        void display();
        void reverse();
        
        singleLinkedList() 
        {
            start = NULL;
        }
};

// define method for createNode using scope operator
node *singleLinkedList::createNode(int value)
{
    struct node *temp, *s;
    temp = new(struct node); 
    if (temp == NULL)
    {
        cout << "Memory not allocated "<<endl;
        return 0;
    }
    else
    {
        temp->info = value;
        temp->next = NULL;     
        return temp;
    }
}
 
// define method for insertAtHead using scope operator
// insert node to the beginning of the linked list
void singleLinkedList::insertAtHead()
{
    int value;
    cout << "Enter the value to be inserted: ";
    cin >> value;
    struct node *temp, *p;
    temp = createNode(value);
    if (start == NULL)
    {
        start = temp;
        start->next = NULL;          
    } 
    else
    {
        p = start;
        start = temp;
        start->next = p;
    }
    cout << "Element inserted at the beginning of the linked list" << endl;
}

// define method for insertAtTail using scope operator
// insert node at the end of the linked list
void singleLinkedList::insertAtTail()
{
    int value;
    cout << "Enter the value to be inserted: ";
    cin >> value;
    struct node *temp, *s;
    temp = createNode(value);
    s = start;
    while (s->next != NULL)
    {         
        s = s->next;        
    }
    temp->next = NULL;
    s->next = temp;
    cout << "Element inserted at the end of the linked list" << endl;  
}

// define method for insertAtPosition using scope operator
// insert node at given position
void singleLinkedList::insertAtPosition()
{
    int value, pos, counter = 0; 
    cout << "Enter the value to be inserted: ";
    cin >> value;
    struct node *temp, *s, *ptr;
    temp = createNode(value);
    cout << "Enter the postion at which node to be inserted: ";
    cin >> pos;
    int i;
    s = start;
    while (s != NULL)
    {
        s = s->next;
        counter++;
    }
    if (pos == 1)
    {
        if (start == NULL)
        {
            start = temp;
            start->next = NULL;
        }
        else
        {
            ptr = start;
            start = temp;
            start->next = ptr;
        }
    }
    else if (pos > 1  && pos <= counter)
    {
        s = start;
        for (i = 1; i < pos; i++)
        {
            ptr = s;
            s = s->next;
        }
        ptr->next = temp;
        temp->next = s;
    }
    else
    {
        cout << "Positon out of range" << endl;
    }
}

// define method for sort using scope operator
// sort the elements in the linked list
void singleLinkedList::sort()
{
    struct node *ptr, *s;
    int value;
    if (start == NULL)
    {
        cout << "The List is empty" << endl;
        return;
    }
    ptr = start;
    while (ptr != NULL)
    {
        for (s = ptr->next;s !=NULL;s = s->next)
        {
            if (ptr->info > s->info)
            {
                value = ptr->info;
                ptr->info = s->info;
                s->info = value;
            }
        }
        ptr = ptr->next;
    }
}

// define method for deleteAtPosition using scope operator
// delete node at given position
void singleLinkedList::deleteAtPosition()
{
    int pos, i, counter = 0;
    if (start == NULL)
    {
        cout << "List is empty" << endl;
        return;
    }
    cout << "Enter the position of the node to be deleted: ";
    cin >> pos;
    struct node *s, *ptr;
    s = start;
    if (pos == 1)
    {
        start = s->next;
    }
    else
    {
        while (s != NULL)
        {
            s = s->next;
            counter++;  
        }
        if (pos > 0 && pos <= counter)
        {
            s = start;
            for (i = 1;i < pos;i++)
            {
                ptr = s;
                s = s->next;
            }
            ptr->next = s->next;
        }
        else
        {
            cout << "Position out of range" << endl;
        }
        free(s);
        cout << "Element Deleted" << endl;
    }
}

// define method for updateNode using scope operator
// update the value of the given node
void singleLinkedList::updateNode()
{
    int value, pos, i;
    if (start == NULL)
    {
        cout << "List is empty" << endl;
        return;
    }
    cout << "Enter the node postion to be updated: ";
    cin >> pos;
    cout << "Enter the new value: ";
    cin >> value;
    struct node *s, *ptr;
    s = start;
    if (pos == 1)
    {
        start->info = value; 
    }
    else
    {
        for (i = 0;i < pos - 1;i++)
        {
            if (s == NULL)
            {
                cout << "There are less than " << pos << " elements";
                return;
            }
            s = s->next;
        }
        s->info = value;  
    }
    cout << "Node Updated" << endl;
} 

// define method for search using scope operator
// search for an element (node) in the linked list
void singleLinkedList::search()
{
    int value, pos = 0;
    bool flag = false;
    if (start == NULL)
    {
        cout<<"List is empty"<<endl;
        return;
    }
    cout << "Enter the value to be searched: ";
    cin >> value;
    struct node *s;
    s = start;
    while (s != NULL)
    {
        pos++;
        if (s->info == value)
        {
            flag = true;
            cout << "Element " << value << " is found at position " << pos << endl;
        }
        s = s->next;
    }
    if (!flag)
        cout << "Element " << value << " not found in the list" << endl;  
}

// define method for display using scope operator
// print elements in the linked list
void singleLinkedList::display()
{
    struct node *temp;
    if (start == NULL)
    {
        cout << "The List is Empty" << endl;
        return;
    }
    temp = start;
    cout << "Elements of list are: " << endl;
    while (temp != NULL)
    {
        cout << temp->info << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

// define method for reverse using scope operator
// reverse all the elements in the linked list
void singleLinkedList::reverse()
{
    struct node *ptr1, *ptr2, *ptr3;
    if (start == NULL)
    {
        cout << "List is empty" << endl;
        return;
    }
    if (start->next == NULL)
    {
        return;
    }  
    ptr1 = start;
    ptr2 = ptr1->next;
    ptr3 = ptr2->next;
    ptr1->next = NULL;
    ptr2->next = ptr1;
    while (ptr3 != NULL)
    {
        ptr1 = ptr2;
        ptr2 = ptr3;
        ptr3 = ptr3->next;
        ptr2->next = ptr1;         
    }
    start = ptr2;
}
 
// menu
int main()
{
    int choice, nodes, element, position, i;
    singleLinkedList sl;
    start = NULL;

    while (1)
    {
        cout << endl << "Singly Linked List Menu" << endl;
        cout << endl << "---------------------------------" <<endl;
        cout << "1. Insert node at the Head" << endl;
        cout << "2. Insert node at the Tail" << endl;
        cout << "3. Insert node at position" << endl;
        cout << "4. Sort Link List" << endl;
        cout << "5. Delete a Specific Node" << endl;
        cout << "6. Update Node Value" << endl;
        cout << "7. Search Element" << endl;
        cout << "8. Display Linked List" << endl;
        cout << "9. Reverse Linked List " << endl;
        cout << "10. Exit " << endl;
        cout << "Enter your choice : ";
        cin >> choice;

        switch(choice)
        {
        case 1:
            cout << "Inserting Node at the Head" << endl;
            sl.insertAtHead();
            cout << endl;
            break;
        case 2:
            cout << "Inserting Node at the Tail" << endl;
            sl.insertAtTail();
            cout << endl;
            break;
        case 3:
            cout << "Inserting Node at a given position" << endl;
            sl.insertAtPosition();
            cout << endl;
            break;
        case 4:
            cout << "Sort Link List: " << endl;
            sl.sort();
            cout << endl;
            break;
        case 5:
            cout << "Deleting a specific node" << endl;
            sl.deleteAtPosition();
            break;
        case 6:
            cout << "Update Node Value:" << endl;  
            sl.updateNode();
            cout << endl;
            break;
        case 7:
            cout << "Search element in Link List: " << endl;
            sl.search();
            cout << endl;
            break;
        case 8:
            cout << "Display elements of link list" << endl;
            sl.display();
            cout << endl;
            break;
        case 9:
            cout << "Reverse elements of Link List" << endl;
            sl.reverse();
            cout << endl;
            break;
        case 10:
            cout << "Exiting..." << endl;
            exit(1);
            break;  
        default:
            cout << "Wrong choice" << endl;
        }
    }
    return 0;
}

