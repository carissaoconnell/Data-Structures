// Breadth First Serach for Directed Graph

import java.io.*;    
import java.util.*;  

public class DirectedGraphBFS 
{    
    // total number number of vertices in the graph
    private int vertices;    
    // declare adjacency list
    private LinkedList<Integer> adjacencyList[];   
    // maintain a queue for the nodes visited in the BFS 
    private Queue<Integer> queueOfNodes; 
    
    // constructor for adjacency list
    DirectedGraphBFS(int vertex)    
    {    
        vertices = vertex;    
        adjacencyList = new LinkedList[vertices];    
        for (int i = 0; i < vertex; i++) {    
            adjacencyList[i] = new LinkedList<>();    
        }    
        queueOfNodes = new LinkedList<Integer>();    
    }    

    // method to add edges to between nodes in adjacency list
    void addEdge(int startNode,int destinationNode) 
    {    
        adjacencyList[startNode].add(destinationNode);   
    }  

    // method for Breadth First Search
    void BFS(int source) 
    {   
        // boolean array to track visited nodes
        boolean visited[] = new boolean[vertices];  
        int node = 0;   // a 
        visited[source] = true;
        //root node is added to the top of the queue                     
        queueOfNodes.add(source);  
        
        while (queueOfNodes.size() != 0)    
        {   
            // retrieve and remove the top element of the queue
            source = queueOfNodes.poll();
            // print top element of the queue
            System.out.print(source + " ");   
            // iterate through the linked list and push all neighbors into queue
            for (int i = 0; i < adjacencyList[source].size(); i++)          
            {
                node = adjacencyList[source].get(i);  
                // only insert nodes into queue if they have not been explored already  
                if (!visited[node])         
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

Example:

Enter the number of edges in the graph: 
3
Enter the <start node> and its <connected node> : 
0 1
Enter the <start node> and its <connected node> : 
1 2
Enter the <start node> and its <connected node> : 
2 0
Enter the vertex to start the Breadth First Search: 
2

Following is the Breadth First Traversal: 2 0 1 

*/
