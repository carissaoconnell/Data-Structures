// DFS for Undirected Graph

import java.util.*;

public class UndirectedGraphDFS {
  private LinkedList<Integer> adjacencyList[]; // declare the adjacency list as a linked list
  private boolean visited[]; // declare the list to check for the nodes that are visited

  // declare the constructor Graph that takes in the vertices and adds them to teh adjacency list and the boolean visited array
  UndirectedGraphDFS(int vertices) {
    adjacencyList = new LinkedList[vertices];
    visited = new boolean[vertices];

    for (int i = 0; i < vertices; i++) {
      adjacencyList[i] = new LinkedList<Integer>();
    }
  }

  // declare constructor to create the edge by taking in the source and destination node
  void addEdge(int source, int destination) {
    adjacencyList[source].add(destination);
  }

  // DFS algorithm
  void DFS(int vertex) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    Iterator<Integer> iterator = adjacencyList[vertex].listIterator();
    while (iterator.hasNext()) {
      int adjacentNode = iterator.next();
      if (!visited[adjacentNode])
        DFS(adjacentNode);
    }
  }

  public static void main(String args[]) {
    int numEdges, startNode, destinationNode;
    Scanner userInput = new Scanner(System.in);

     System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();
		    UndirectedGraphDFS graph = new UndirectedGraphDFS(numEdges);

        while(numEdges != 0) {
          numEdges = numEdges - 1;
          System.out.println("Enter the <start node> and its <connected node> : ");
          startNode = userInput.nextInt();
          destinationNode = userInput.nextInt();
          graph.addEdge(startNode,destinationNode);
        }
        
        // print the DFS Traversal sequence
        System.out.println("Enter the vertex to start the DFS from: " ); 
          int DFSvertex = userInput.nextInt();

        System.out.println("\nFollowing is the Depth First Traversal");
          graph.DFS(DFSvertex);
  }
}


/*

Example input:

Enter the number of edges in the graph: 
4

Enter the <start node> and its <connected node> : 
0 1
0 2
1 2
2 3

Enter the vertex to start the DFS from: 
0

Following is the Depth First Traversal
0 1 2 3 

 */