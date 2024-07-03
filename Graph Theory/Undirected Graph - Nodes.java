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
        LinkedList<Node> sourceList = verticesList.get(source);
        Node destinationNode = verticesList.get(destination).get(0);
        sourceList.add(destinationNode);
    
        LinkedList<Node> destinationList = verticesList.get(destination);
        Node sourceNode = verticesList.get(source).get(0);
        destinationList.add(sourceNode);
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
Enter the number of nodes: 3
Enter node 1: 0
Enter node 2: 1
Enter node 3: 2
Enter the number of edges: 2
Enter edge 1 (source destination): 0 1
Enter edge 2 (source destination): 0 2
0 -> 1 -> 2 -> 
1 -> 0 -> 
2 -> 0 -> 
 * 
 * 
 */
