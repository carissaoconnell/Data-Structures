// Java program to print directed graph

import java.util.*;

public class DirectedGraph {
    int vertex;
    LinkedList<Integer> adjacencyList[];

    public DirectedGraph(int vertex) {
        this.vertex = vertex;
        adjacencyList = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        // Add edge from source to destination
        adjacencyList[source].add(destination);
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                System.out.print(adjacencyList[i].get(j) + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int numVertices, numEdges, startNode, destinationNode;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph: ");
        numVertices = userInput.nextInt();
        DirectedGraph graph = new DirectedGraph(numVertices);

        System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();

        while(numEdges!= 0) {
            numEdges = numEdges - 1;
            System.out.println("Enter the <start node> and its <connected node> : ");
            startNode = userInput.nextInt();
            destinationNode = userInput.nextInt();
            graph.addEdge(startNode,destinationNode);
        }
        graph.printGraph();
    }
}

/*

Example Inputs:

Enter the number of vertices in the graph: 
4
Enter the number of edges in the graph: 
7
Enter the <start node> and its <connected node> : 
0 1
Enter the <start node> and its <connected node> : 
0 4
Enter the <start node> and its <connected node> : 
1 2
Enter the <start node> and its <connected node> : 
1 3
Enter the <start node> and its <connected node> : 
1 4
Enter the <start node> and its <connected node> : 
2 3
Enter the <start node> and its <connected node> : 
3 4
Vertex 0 is connected to: 1 4 
Vertex 1 is connected to: 2 3 4 
Vertex 2 is connected to: 3 
Vertex 3 is connected to: 4 

 */
