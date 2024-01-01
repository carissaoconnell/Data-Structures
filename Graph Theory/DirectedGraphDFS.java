// Depth First Search for Directed Graph

import java.util.*;  
  
class DirectedGraphDFS {  
  private LinkedList<Integer> adjacencyList[]; 
  private boolean visited[];  // boolean array to store visited nodes
  
  // constructor for graph 
  DirectedGraphDFS(int vertices)  
  {  
    adjacencyList = new LinkedList[vertices];
    visited = new boolean[vertices];  
  
    for (int i = 0; i < vertices; i++)  
      adjacencyList[i] = new LinkedList<Integer>();  
  }  
  
  // method to add edge to gaph
  void addEdge(int source, int destination) 
  {
    adjacencyList[source].add(destination);  
  }  
  
  void DFS(int vertex) 
  { 
    // mark the current node as visited
    visited[vertex] = true;
    System.out.print(vertex + " ");  
  
    // iterate through all the vertices in the adjacency list
    Iterator<Integer> nodeIterator = adjacencyList[vertex].listIterator();
    while (nodeIterator.hasNext()) 
    {  
      int nextNode = nodeIterator.next();  
      if (!visited[nextNode]) 
      {  
        DFS(nextNode);  
      }
    }  
  }  
  
  public static void main(String args[]) 
  {  
    int numEdges, startNode, destinationNode;
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter the number of edges in the graph: ");
    numEdges = userInput.nextInt();
		DirectedGraphDFS graph = new DirectedGraphDFS(numEdges);

    while(numEdges != 0) 
    {
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
      Enter the number of edges in the graph: 10

      Enter the <start node> and its <connected node> : 
      0 , 1
      0 , 2
      0 , 3
      1 , 3
      2 , 4
      3 , 5
      3 , 6
      4 , 7
      4 , 5
      5 , 2

    Enter the vertex to start the DFS from: 0
        
    Following is the Depth First Traversal
    0 1 3 5 2 4 7 6 
 */