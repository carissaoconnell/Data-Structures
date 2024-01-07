// stack as linked list built by user's input

import java.util.*;
import static java.lang.System.exit;

class stackLinkedlist { 
   
    // Define Node of LinkedList 
    private class Node { 
        int value; // node named as value 
        Node nodeLink; // Node link 
    } 

    // top of the stack 
    Node topNode; 
    // stack class Constructor 
    stackLinkedlist() { 
        this.topNode = null; 
    } 
   
    // push () method 
    public void push(int nodeToInsert) {
        // create a new node 
        Node tempNode = new Node();
   
        // assign value to node 
        tempNode.value = nodeToInsert; 
   
        // set top node of the stack to node link
        tempNode.nodeLink = topNode; 
   
        // update top to be the temporary node
        topNode = tempNode; 
    }   

      // isEmpty () method
    public boolean isEmpty() { 
        return topNode == null; 
    } 
 
    // peek () method 
    public int peek() { 
        // check if the stack is empty 
        // if the stack is not empty
        if (!isEmpty()) { 
            // return the value of the top node
            return topNode.value; 
        } 
        else { 
            System.out.println("Stack is empty!"); 
            return -1; 
        } 
    } 
   
    // pop () operation 
    public void pop() { 
        // check if stack is out of elements 
        if (topNode == null) { 
            System.out.print("\nStack Underflow!!"); 
            return; 
        } 
        // set top node to point to next node 
        topNode = (topNode).nodeLink; 
    } 
   
    //print stack contents
    public void display() { 
        // check for stack underflow 
        if (topNode == null) { 
            System.out.printf("\nStack Underflow!!"); 
            exit(1); 
        } 
        // if the top node is not null
        else { 
            // set the top node as the temporary node
            Node tempNode = topNode;
            System.out.println("Stack elements:");
            // if the temporary node is not null
            while (tempNode != null) { 
                  // print value of node
                System.out.print(tempNode.value + " -> ");
                // assign temporary link to temporary node
                tempNode = tempNode.nodeLink; 
            } 
        } 
    } 
} 
 
public class Main { 
    public static void main(String[] args) { 
        // Create a stack class object 
        stackLinkedlist stackLinkedListObject = new stackLinkedlist(); 

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the amount of elements to add to Stack: ");
        int numElements = userInput.nextInt();
        
        while(numElements != 0) {
            numElements  = numElements  - 1;
            System.out.println("Enter element to input into stack: ");
            int element = userInput.nextInt();
            stackLinkedListObject.push(element);
        }

        // print Stack elements 
        stackLinkedListObject.display(); 
   
        // print current element at the top of the Stack
        System.out.println("\nStack top: " + stackLinkedListObject.peek());
 
        // Pop elements twice 
        System.out.println("Pop two elements");
        stackLinkedListObject.pop(); 
        stackLinkedListObject.pop();
   
        // print elements in the Stack
        stackLinkedListObject.display(); 
   
        // print new element at top of Stack
        System.out.println("\nNew Stack top: " + stackLinkedListObject.peek()); 
    } 
}



/*
    Example Input

    Enter the amount of elements to add to Stack: 5

    Enter element to input into stack: 
    9
    7
    5
    3
    1


    Expected Output

    Stack elements:
    1 -> 3 -> 5 -> 7 -> 9 -> 
    Stack top: 1
    Pop two elements
    Stack elements:
    5 -> 7 -> 9 -> 
    New Stack top: 5
 */
