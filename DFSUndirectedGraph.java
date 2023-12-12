//DFS Technique for undirected graph

import java.io.*; 
import java.util.*; 
   
class DFSUndirectedGraph { 
    private int Vertices;   // No. of vertices 
   
    // adjacency list declaration
    private LinkedList<Integer> adjacencyList[]; 
   
    // graph Constructor: to initialize adjacency lists as per no of vertices 
    Graph(int vertex) { 
        Vertices = vertex; 

        // add the vertex to the linked list called adjacencyList
        adjacencyList = new LinkedList[vertex]; 
        // iterate through every element in the adjacencyList
        for (int i = 0; i < vertex; ++i) {
            adjacencyList[i] = new LinkedList(); 
        }
    } 
   
    //add an edge to the graph 
    void addEdge(int sourceNodes, int cost) { 
        // Add cost (node) to sourceNodes's list.
        adjacencyList[sourceNodes].add(cost);   
    } 
   
    // helper function for DFS technique
    void visitedNodes(int sourceNode, boolean visited[]) {
        // mark current node visited as true
        visited[sourceNode] = true; 
        System.out.print(sourceNode + " "); 
   
        // process all adjacent vertices 
        Iterator<Integer> adjacentVertices = adjacencyList[sourceNode].listIterator();
        while (adjacentVertices.hasNext()) 
        { 
            int nextNode = adjacentVertices.next(); 
            if (!visited[nextNode]) {
                visitedNodes(nextNode, visited); 
            }
        }
    }
    
    void DFS(int sourceNode) { 
        //initially none of the vertices are visited 
        boolean visited[] = new boolean[Vertices]; 
   
        // call recursive DFS_helper function for DFS technique 
        visitedNodes(sourceNode, visited); 
    }

    public static void main(String args[]) 
    { 
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
        
        //print the DFS Traversal sequence
        System.out.println("Depth First Traversal for given graph from vertex: " ); 
            int DFSvertex = userInput.nextInt();
            graph.DFS(DFSvertex);
    } 
}


/*

Example inputs

Edges in graph: 5

0 1
0 2
0 3
1 2
2 4  

Depth First Search from vertex: 0

Expected Output:
0 1 2 4 3

*/