import java.util.*;

class Node {
    char data;

    Node(char data) {
        this.data = data;
    }
}

class Graph {
    ArrayList<LinkedList<Node>> verticesList;

    Graph() {
        verticesList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        verticesList.add(currentList);
    }

    public void addEdge(int source, int destination) {
        LinkedList<Node> currentList = verticesList.get(source);
        Node destinationNode = verticesList.get(destination).get(0);
        currentList.add(destinationNode);
    }

    public void print() {
        for (LinkedList<Node> currentList : verticesList) {
            for (Node node : currentList) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int numNodes = userInput.nextInt();

        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter node " + (i + 1) + ": ");
            char nodeData = userInput.next().charAt(0);
            graph.addNode(new Node(nodeData));
        }

        System.out.print("Enter the number of edges: ");
        int numEdges = userInput.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge " + (i + 1) + " (source destination): ");
            int source = userInput.nextInt();
            int destination = userInput.nextInt();
            graph.addEdge(source, destination);
        }

        graph.print();
    }
}

/*
 * Example:
 * 
Enter the number of nodes: 5
Enter node 1: 0
Enter node 2: 1
Enter node 3: 2
Enter node 4: 3
Enter node 5: 4
Enter the number of edges: 4
Enter edge 1 (source destination): 0 1
Enter edge 2 (source destination): 0 2
Enter edge 3 (source destination): 1 3
Enter edge 4 (source destination): 2 4
0 -> 1 -> 2 -> 
1 -> 3 -> 
2 -> 4 -> 
3 -> 
4 -> 
 * 
 * 
 */
