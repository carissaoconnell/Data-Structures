import java.util.InputMismatchException;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    void displayTopToBottom() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayBottomToTop() {
        Node temp = top;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = getPreviousNode(top, temp);
        }
        System.out.println();
    }

    Node getPreviousNode(Node head, Node node) {
        while (head.next != node) {
            head = head.next;
        }
        return head;
    }

    int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
}

class Queue {
    Node front;
    Node rear;

    void enqueue(int data) {
        Node node = new Node(data);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    void displayQueueElements() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new Queue();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("1. Push to stack");
            System.out.println("2. Enqueue to queue");
            System.out.println("3. Pop from stack");
            System.out.println("4. Dequeue from queue");
            System.out.println("5. Display stack from top to bottom");
            System.out.println("6. Display stack from bottom to top");
            System.out.println("7. Peek top element of stack");
            System.out.println("8. Peek front element of queue");
            System.out.println("9. Display queue elements");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter element to push to stack: ");
                        int element = userInput.nextInt();
                        stack.push(element);
                        break;
                    case 2:
                        System.out.print("Enter element to enqueue to queue: ");
                        element = userInput.nextInt();
                        queue.enqueue(element);
                        break;
                    case 3:
                        stack.pop();
                        break;
                    case 4:
                        queue.dequeue();
                        break;
                    case 5:
                        stack.displayTopToBottom();
                        break;
                    case 6:
                        stack.displayBottomToTop();
                        break;
                    case 7:
                        System.out.println("Top element of stack: " + stack.peek());
                        break;
                    case 8:
                        System.out.println("Front element of queue: " + queue.peek());
                        break;
                    case 9:
                        queue.displayQueueElements();
                        break;
                    case 10:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                userInput.next(); // Consume the invalid input
            }
        }
    }
}