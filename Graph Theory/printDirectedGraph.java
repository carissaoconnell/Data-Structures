// Java program to print directed graph

import java.util.*;

    public class Graph {
        int vertex;
        LinkedList<Integer> adjacencyList[];
        
        public Graph(int vertex) {
            this.vertex = vertex;
            adjacencyList = new LinkedList[vertex];
            for (int i = 0; i <vertex ; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            //add edge
            adjacencyList[source].addFirst(destination);
            //add back edge (for undirected)
            adjacencyList[destination].addFirst(source);
        }

        public void printGraph(){
            for (int i = 0; i <vertex ; i++) {
                if(adjacencyList[i].size() > 0) {
                    System.out.print("Vertex " + i + " is connected to: ");
                        for (int j = 0; j < adjacencyList[i].size(); j++) {
                            System.out.print(adjacencyList[i].get(j) + " ");
                        }
                System.out.println();
                }
            }
        }


    public static void main(String[] args) {

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
            graph.printGraph();
    }
}


/*

Example Inputs:

Number of Edges in the graph: 7

0 1
0 4
1 2
1 3
1 4
2 3
3 4

Expected Output:
Vertex 0 is connected to: 4 1 
Vertex 1 is connected to: 4 3 2 0 
Vertex 2 is connected to: 3 1 
Vertex 3 is connected to: 4 2 1 
Vertex 4 is connected to: 3 1 0 

 */