//BFS for Directed Graph

import java.io.*;    
import java.util.*;  

public class DirectedGraphBFS 
{    
    private int vertices;       /* total number number of vertices in the graph */    
    private LinkedList<Integer> adjacencyList[];      /* adjacency list */    
    private Queue<Integer> queueOfNodes;           /* maintaining a queue */    
    
    DirectedGraphBFS(int vertex)    
    {    
        vertices = vertex;    
        adjacencyList = new LinkedList[vertices];    
        for (int i = 0; i < vertex; i++) {    
            adjacencyList[i] = new LinkedList<>();    
        }    
        queueOfNodes = new LinkedList<Integer>();    
    }    


    void addEdge(int startNode,int destinationNode) 
    {    
        adjacencyList[startNode].add(destinationNode);      /* adding an edge to the adjacency list (edges are bidirectional in this example) */    
    }  


    void BFS(int source) 
    {    
        boolean visited[] = new boolean[vertices];       /* initialize boolean array for holding the data */    
        int node = 0;   // a 
        visited[source] = true;                      
        queueOfNodes.add(source);       /* root node is added to the top of the queue */    
        
        while (queueOfNodes.size() != 0)    
        {    
            source = queueOfNodes.poll();        /* remove the top element of the queue */     
            System.out.print(source + " ");    /* print the top element of the queue */    
            for (int i = 0; i < adjacencyList[source].size(); i++)  /* iterate through the linked list and push all neighbors into queue */        
            {
                node = adjacencyList[source].get(i);    
                if (!visited[node])      /* only insert nodes into queue if they have not been explored already */    
                {    
                    visited[node] = true;    
                    queueOfNodes.add(node);    
                }    
            }      
        }    
    }   
    
    
    public static void main(String args[])    
    {    
        int numEdges, startNode, destinationNode;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();
		  DirectedGraphBFS graph = new DirectedGraphBFS(numEdges);

        while(numEdges != 0) 
        {
            numEdges = numEdges - 1;
            System.out.println("Enter the <start node> and its <connected node> : ");
            startNode = userInput.nextInt();
            destinationNode = userInput.nextInt();
            graph.addEdge(startNode,destinationNode);
        }

    System.out.println("Enter the vertex to start the Breadth First Search: ");
      int BFSvertex = userInput.nextInt();

    System.out.print("\nFollowing is the Breadth First Traversal: ");
      graph.BFS(BFSvertex);
    }    
} 

/*
@Test 
public class DirectedGraphBFSTest
{
     DirectedGraphBFS graph = new BFSTraversal(13); 
        graph.addEdge(0, 1);    
        graph.addEdge(0, 2);    
        graph.addEdge(0, 3);    
        graph.addEdge(1, 3);    
        graph.addEdge(2, 4);  
        graph.addEdge(3, 5);       
        graph.addEdge(3, 6);    
        graph.addEdge(4, 7);    
        graph.addEdge(4, 5);    
        graph.addEdge(5, 2);    
        graph.addEdge(6, 5);    
        graph.addEdge(7, 5);  
        graph.addEdge(7, 8);   

        System.out.println("Breadth First Traversal for the graph is:");    
        
        graph.BFS(2);  

        Following is the Breadth First Traversal:
        2 4 7 5 8  
}
*/