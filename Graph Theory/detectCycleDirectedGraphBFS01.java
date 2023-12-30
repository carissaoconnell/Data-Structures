// detect cycle in a Directed Graph using Breadth First Search

import java.io.*;
import java.util.*;

class detectCycleDirectedGraphBFS01
{
	// Class to represent a graph
	static class DirectedGraphBFS
	{
		int numOfVertices; // No. of vertices'

		// Pointer to an array containing adjacency list
		Vector<Integer>[] adjacenyList;

        // Constructor for Directed Graph
		@SuppressWarnings("unchecked")
		DirectedGraphBFS(int numOfVertices)
		{
			this.numOfVertices = numOfVertices;
			this.adjacenyList = new Vector[numOfVertices];
			for (int i = 0; i < numOfVertices; i++)
				adjacenyList[i] = new Vector<>();
		}

		// function to add an edge to graph
		void addEdge(int sourceNode, int destinationNode)
		{
			adjacenyList[sourceNode].add(destinationNode);
		}

        // Boolean function that detects if there is a cycle in the Directed Graph
		// This function returns true if there is a cycle
		// in directed graph, else returns false.
		boolean detectGraphCycle() 
		{
			// Create a vector to store indegrees of all vertices. 
            // Initialize all indegrees as 0.
			int[] inDegrees = new int[this.numOfVertices];
			Arrays.fill(inDegrees, 0);

			// Traverse adjacency lists to fill indegrees of vertices
			for (int numOfTraversals = 0; numOfTraversals < numOfVertices; numOfTraversals++)
			{
				for (int vertex : adjacenyList[numOfTraversals]) {
					inDegrees[vertex]++;
                }
			}

			// Create a queue and enqueue all vertices with an indegree of 0
			Queue<Integer> queueOfVertices = new LinkedList<Integer>();
			for (int i = 0; i < numOfVertices; i++) {
				if (inDegrees[i] == 0) 
                {
					queueOfVertices.add(i);
                }
            }

			// count to keep track of visited vertices
			int count = 0;

			// Vector to store results 
            // as a topological ordering of the vertices
			Vector<Integer> verticesInTopologicalOrder = new Vector<>();

			// One by one dequeue vertices from queue and enqueue
			while (!queueOfVertices.isEmpty())
			{
				// retrieve and remove head element from queueOfVertices 
                // and label it as visitedVertex
                // add the visitedVertex to the vector verticesInTopologicalOrder
				int visitedVertex = queueOfVertices.poll();
				verticesInTopologicalOrder.add(visitedVertex);

				// Iterate through all its neighbouring nodes
				// of dequeued node visitedVertex and decrease their in-degree
				// by 1, For every vertex it decreases, increment counter by one.
				for (int nodeIterator : adjacenyList[visitedVertex])
					if (--inDegrees[nodeIterator] == 0)
                    {
						queueOfVertices.add(nodeIterator);
                    }
				count++;
			}

			// Check if there was a cycle
			if (count != this.numOfVertices)
				return true;
			else
				return false;
		}
	}

	// Driver Code
	public static void main(String[] args) 
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

		if (graph.detectGraphCycle())
			System.out.println("A cycle was found in the graph");
		else
			System.out.println("A cycle was NOT found in the graph");
	}
}

/*
 @Test {
    Enter the number of edges in the graph: 6

    0 , 1
    1 , 2
    2 , 0
    2 , 3
    3 , 4
    4 , 5

 }

 Expected Output: A cycle was found in the graph

 */
