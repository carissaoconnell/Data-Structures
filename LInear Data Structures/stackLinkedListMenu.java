// Stack as Linked List using Generics

import java.util.*;

public class stackLinkedListMenu { 
	// main driver method 
	public static void main(String[] args) 
	{ 
		// create an object of LinkedStack 
		LinkedStack<Double> stackLinkedList = new LinkedStack<>(); 

		Scanner userInput = new Scanner(System.in); 

		do { 
			// As we are writing a menu driven program so 
			// user can choose the operation he wants 
			System.out.println("-----MENU-----"); 

            System.out.println("1. Add an element to the Stack");
            System.out.println("2. Pop an element to the Stack");
            System.out.println("3. Peek element from Stack");
            System.out.println("4. Display elements in Stack");
            System.out.println("5. Find size of Stack");
            System.out.println("6. EXIT");
            System.out.println("Enter your choice:"); 

			int choice = userInput.nextInt(); 

			switch (choice) {			 
			case 1: 
				System.out.println("Enter the element to insert into Stack:"); 
				Double elementToInsert = userInput.nextDouble(); 
				stackLinkedList.push(elementToInsert); 
				break; 
			
			case 2: 
				System.out.print("Poped element: "); 
				System.out.println(stackLinkedList.pop()); 
				break; 
			
			case 3: 
				System.out.println("Topmost element :"); 
				System.out.println(stackLinkedList.peek()); 
				break; 
			
			case 4: 
				stackLinkedList.display(); 
				break; 
			
			case 5: 
				System.out.println("Total elements on stack: "+ stackLinkedList.size()); 
				break; 
			
			case 6: 
				System.exit(1); 
			
			default: 
				System.out.println("Please make another choice!"); 
			} 
		} 
	while (true); 
	} 
}

class LinkedStack<T> { 
    // create a Node class 
    private class Node { 
  
        // A Node contains two parts inside it one is the
        // value part and the other is the nextNode which has a 
        // reference to the next Node 
        T value; 
        Node nextNode; 
  
        // constructor for local variables of Node class
        public Node(T value, Node nextNode) 
        { 
            this.value = value; 
            this.nextNode = nextNode; 
        } 
  
        public String toString() 
        { 
            // returns the data in string format 
            return value.toString(); 
        } 
    } 
    // topNode acts as a reference to the Node 
    private Node topNode; 
    public boolean isEmpty() { 
        return topNode == null; 
    } 
    public void push(T newNode) 
    { 
        // Every time  when a new element is pushed onto the 
        // stack a new Node is created and topNode is pointed to it
        topNode = new Node(newNode, topNode); 
    } 
    public T pop() 
    { 
        // check if elements are present in the Stack or not 
        if (topNode == null) 
            return null; 
        else { 
            // if an element is present 
            // do the following:
            // Assign the topmost element in the 
            // stack into a variable 
            T element = topNode.value; 
            // make topNode point to it's next node 
            topNode = topNode.nextNode; 
            // Popped element is returned to 
            // the main 
            return element; 
        } 
    } 
    public T peek() 
    { 
        // return the element which is 
        // at beginning of the stack 
        return topNode.value; 
    } 
    public int size() 
    { 
        // This method returns the number of  
        // elements currently in the stack 
        int count = 0; 
        Node tempNode = topNode; 
  
        while (tempNode != null) { 
            // increment count 
            count += 1; 
            // make temp to point to
            // the next Node 
            tempNode = tempNode.nextNode; 
        } 
  
        return count; 
    } 
      public void display() 
    { 
        // This method displays every element 
        // in the Stack
        System.out.println("The elements of the stack are: "); 
        Node tempNode = topNode; 

        while (tempNode != null) { 
            // print the data in 'temp' 
            System.out.print(tempNode.value + " ->"); 
            // make temp to point it's 
            // next Node 
            tempNode = tempNode.nextNode; 
        } 
        // indicates that last Node is not 
        // pointing to any Node 
        System.out.println("null"); 
  
        System.out.println(); 
    } 
} 
