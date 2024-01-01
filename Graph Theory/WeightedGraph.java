// adjacency list for weighted graph 

import java.util.*;

public class WeightedGraph 
{    
    static class Edge 
    {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) 
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }


    static class Graph 
    {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) 
        {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }


        public void addEdge(int source, int destination, int weight) 
        {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); //for directed graph
        } 


        public void printGraph() 
        {
            for (int i = 0; i <vertices ; i++) 
            {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) 
                {
                    System.out.println("vertex: " + i + "   is connected to vertex: " 
                    + list.get(j).destination + "   with weight " +  list.get(j).weight);
                }
            }
        }

    } // end Graph constructor


    // driver method
    public static void main(String[] args) 
    {
        int edges, startNode, destinationNode, cost;  // weight or distance between vertices;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the number of edges in the graph: ");
            edges = userInput.nextInt();
            Graph weightedGraph = new Graph(edges);
        
            while(edges-- > 0) 
            {
                System.out.println("Enter the <start vertex>, <connected vertex>, and <cost/weight> of the vertex: ");
                    startNode = userInput.nextInt();
                    destinationNode = userInput.nextInt();
                    cost = userInput.nextInt();
                    
                    weightedGraph.addEdge(startNode,destinationNode,cost);
            }
            weightedGraph.printGraph();
    }  // end driver method

}  // end WeightedGraph class


/*
Example Input:

Enter the number of edges in the graph: 9

    0 1 4
    0 2 3
    1 3 2
    1 2 5
    2 3 7
    3 4 2
    4 0 4
    4 1 4
    4 5 6

*/