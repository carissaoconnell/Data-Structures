import java.util.Scanner;  
class Stack   
{  
    int top;   
    int maxsize = 10;  
    int[] arr = new int[maxsize];  
      
      
    boolean isEmpty()  
    {  
        return (top < 0);  
    }

    Stack()  
    {  
        top = -1;  
    }

    boolean push (Scanner sc)  
    {  
        if(top == maxsize-1)  
        {  
            System.out.println("Overflow!!");  
            return false;  
        }  
        else   
        {  
            System.out.print("Enter Value: ");  
            int val = sc.nextInt();  
            top++;  
            arr[top]=val;  
            System.out.println("Element added");  
            return true;  
        }  
    }

    boolean pop ()  
    {  
        if (top == -1)  
        {  
            System.out.println("Underflow!!");  
            return false;  
        }  
        else   
        {  
            top--;   
            System.out.println("Element has been removed");  
            return true;  
        }  
    }

    void display ()  
    {  
        System.out.println("Elements in the stack:");  
        for(int i = top; i >= 0; i--)  
        {  
            System.out.println(arr[i]);  
        }  
    }  
}

public class Stack_Operations {  
public static void main(String[] args) {  
    int choice = 0;  
    Scanner userInput = new Scanner(System.in);  
    Stack stackArray = new Stack();  
    System.out.println("---------- Stack operations using array ----------\n");  

    while(choice != 4)  
    {  
        System.out.println("\nMenu of options");  
        System.out.println("\n1. Push the element to the stack\n2. Pop the last element from the stack\n3. Display elements in the stack\n4. Exit");  
        System.out.print("Enter your choice: ");        
        choice = userInput.nextInt();  
        switch(choice)  
        {  
            case 1:  
            {   
                stackArray.push(userInput);  
                break;  
            }  
            case 2:  
            {  
                stackArray.pop();  
                break;  
            }  
            case 3:  
            {  
                stackArray.display();  
                break;  
            }  
            case 4:   
            {  
                System.out.println("Exiting....");  
                System.exit(0);  
                break;   
            }  
            default:  
            {  
                System.out.println("Please enter another choice between 1-4");  
            }   
        };  
    }  
}  
} 