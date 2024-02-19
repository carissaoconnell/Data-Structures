#include<iostream>
#include<cmath>
using namespace std;

//the circle class
class Circle
{
    double radius;
    public:

    //Default constructor
    Circle()
    {
        radius = 0;
    }

    //parameterized constructor
    Circle(double radius)
    {
        this->radius = radius;
    }

    //getter function
    double getRadius()
    {
        return radius;
    }

    //setter function
    void setRadius(double radius)
    {
        this->radius = radius;
    }

    double calculateArea()
    {
        return M_PI * radius * radius;
    }
};

class Node
{
public:
    Circle c;
    Node *next;

    //parameterized constructor
    Node(double radius)
    {
        c.setRadius(radius);
        next = NULL;
    }
};

void DisplayAllElements(Node *head)
{
    //we will use this pointer to traverse over our list
    Node *curr = head;
    //initially position will be 1
    int position = 1;
    //until we reach the end of linked list, loop will continue
    while(curr != NULL)
    {
        //print data for each node
        cout << "Position: " << position << "\n";
        cout << "Radius: " << curr->c.getRadius() << "\n";
        cout << "Area: " << curr->c.calculateArea() << "\n\n";

        //move the pointer and increase the position
        curr = curr->next;        
        position++;
    }
}

int main()
{
    //creating head pointer
    Node *head = new Node(1);
    Node *curr = head;

    //creating a linked list containing odd numbers 
    for(int i = 3; i <= 9; i+=2)
    {
        curr->next = new Node(i);
        curr = curr->next;
    }

    //invoking the function
    DisplayAllElements(head);    
    return 0;
}