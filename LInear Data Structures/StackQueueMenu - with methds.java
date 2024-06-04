import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackQueueMenu {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int choice = 10;

        while (choice!= 0) {
            displayMenu();
            choice = getUserChoice(userInput);

            switch (choice) {
                case 1:
                    addElementToStack(userInput, stack);
                    break;
                case 2:
                    addElementToQueue(userInput, queue);
                    break;
                case 3:
                    displayTopElementOfStack(stack);
                    break;
                case 4:
                    displayTopElementOfQueue(queue);
                    break;
                case 5:
                    popElementFromStack(stack);
                    break;
                case 6:
                    removeElementFromQueue(queue);
                case 7:
                    displayStackElementsTopToBottom(stack);
                    break;
                case 8:
                    displayStackElementsBottomToTop(stack);
                    break;
                case 9:
                    displayQueueElements(queue);
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        userInput.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add element to stack");
        System.out.println("2. Add element to queue");
        System.out.println("3. Display top element of stack");
        System.out.println("4. Display top element of queue");
        System.out.println("5. Pop element from stack");
        System.out.println("6. Remove element from queue");
        System.out.println("7. Display stack elements (top to bottom)");
        System.out.println("8. Display stack elements (bottom to top)");
        System.out.println("9. Display queue elements");
        System.out.println("0. Exit");
    }

    private static int getUserChoice(Scanner userInput) {
        System.out.print("Enter your choice: ");
        int choice = userInput.nextInt();
        return choice;
    }

    private static void addElementToStack(Scanner userInput, Stack<Integer> stack) {
        System.out.print("Enter element to add to stack: ");
        int element = userInput.nextInt();
        stack.push(element);
    }

    private static void addElementToQueue(Scanner userInput, Queue<Integer> queue) {
        System.out.print("Enter element to add to queue: ");
        int element = userInput.nextInt();
        queue.add(element);
    }

    private static void displayTopElementOfStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            System.out.println("Top element of stack: " + stack.peek());
        } else {
            System.out.println("Stack is empty");
        }
    }

    private static void displayTopElementOfQueue(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            System.out.println("Top element of queue: " + queue.peek());
        } else {
            System.out.println("Queue is empty");
        }
    }

    private static void popElementFromStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            System.out.println("Popped element from stack: " + stack.pop());
        } else {
            System.out.println("Stack is empty");
        }
    }

    private static void removeElementFromQueue(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            System.out.println("Removed element from queue: " + queue.poll());
        } else {
            System.out.println("Queue is empty");
        }
    }

    private static void displayStackElementsTopToBottom(Stack<Integer> stack) {
        System.out.println("Stack elements (top to bottom):");
        for (int i : stack) {
            System.out.println(i);
        }
    }

    private static void displayStackElementsBottomToTop(Stack<Integer> stack) {
        System.out.println("Stack elements (bottom to top):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    private static void displayQueueElements(Queue<Integer> queue) {
        System.out.println("Queue elements:");
        for (int i : queue) {
            System.out.println(i);
        }
    }
}