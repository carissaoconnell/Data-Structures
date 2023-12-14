import java.util.*;  
  
class DirectedGraphDFS {  
  private LinkedList<Integer> adjacencyList[]; /*adjacency list representation*/  
  private boolean visited[];  // boolean array to store visited nodes
  
  /* Creation of the graph */  
  DirectedGraphDFS(int vertices) /*'V' is the number of vertices in the graph*/  
  {  
    adjacencyList = new LinkedList[vertices];
    visited = new boolean[vertices];  
  
    for (int i = 0; i < vertices; i++)  
      adjacencyList[i] = new LinkedList<Integer>();  
  }  
  
  /* Adding an edge to the graph */  
  void addEdge(int source, int destination) {
    adjacencyList[source].add(destination);  
  }  
  
  void DFS(int vertex) {  
    visited[vertex] = true; /* Mark the current node as visited */  
    System.out.print(vertex + " ");  
  
    Iterator<Integer> nodeIterator = adjacencyList[vertex].listIterator();
    while (nodeIterator.hasNext()) {  
      int nextNode = nodeIterator.next();  
      if (!visited[nextNode])  
        DFS(nextNode);  
    }  
  }  
  
  public static void main(String args[]) {  

    int numEdges, startNode, destinationNode;
    Scanner userInput = new Scanner(System.in);

     System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();
		DirectedGraphDFS graph = new DirectedGraphDFS(numEdges);

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
       DFSTraversal graph = new DFSTraversal(10);  
  
        graph.insertEdge(0, 1);    
        graph.insertEdge(0, 2);    
        graph.insertEdge(0, 3);    
        graph.insertEdge(1, 3);    
        graph.insertEdge(2, 4);  
        graph.insertEdge(3, 5);       
        graph.insertEdge(3, 6);    
        graph.insertEdge(4, 7);    
        graph.insertEdge(4, 5);    
        graph.insertEdge(5, 2);    
          
        System.out.println("Depth First Traversal for the graph is:");    
        graph.DFS(0);    
 */