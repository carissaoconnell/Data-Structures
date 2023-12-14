// BFS for UNDIRECTED GRAPH

import java.util.*;

public class BFSUndirectedGraph {
  private int vertices;
  private LinkedList<Integer> adjacencyList[];

  // Create a graph
  Graph(int vertex) {
    vertices = vertex;
    adjacencyList = new LinkedList[vertex];
    for (int i = 0; i < vertex; ++i) {
      adjacencyList[i] = new LinkedList();
    }
  }

  // Add edges to the graph
  void addEdge(int vertex, int weight) {
    adjacencyList[vertex].add(weight);
  }

  // BFS algorithm
  void BFS(int source) {

    boolean visited[] = new boolean[vertices];

    LinkedList<Integer> queue = new LinkedList();

    visited[source] = true;
    queue.add(source);

    while (queue.size() != 0) {
      source = queue.poll();
      System.out.print(source + " ");

      Iterator<Integer> i = adjacencyList[source].listIterator();
      while (i.hasNext()) {
        int nextNode = i.next();
        if (!visited[nextNode]) {
          visited[nextNode] = true;
          queue.add(nextNode);
        }
      }
    }
  }

  public static void main(String args[]) {

    int numEdges, startNode, destinationNode;
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter the number of edges in the graph: ");
      numEdges = userInput.nextInt();
		  Graph graph = new Graph(numEdges);

        while(numEdges != 0) {
            numEdges = numEdges - 1;
            System.out.println("Enter the <start node> and its <connected node> : ");
            startNode = userInput.nextInt();
            destinationNode = userInput.nextInt();
            graph.addEdge(startNode,destinationNode);
        }

    System.out.println("Following is Breadth First Traversal starting from vertex: ");
      int BFSvertex = userInput.nextInt();
      graph.BFS(BFSvertex);
  }
}


/*

Enter the number of edges in the graph: 6

Enter the <start node> and its <connected node> : 
0 1
0 2
1 2
2 0
2 3
3 3

Following is Breadth First Traversal starting from vertex:  2

Output: 
2 0 3 1

*/