// detect a cycle in an Undirected Graph using Depth First Search

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")

class undirectedGraphCycleDetection 
{
	// no. of vertices
	private int numOfVertices;
	// adjacency list representation
	private LinkedList<Integer> adjacencyList[];

	// constructor for adjacency list
	undirectedGraphCycleDetection(int vertices)
	{
		numOfVertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
		{
			adjacencyList[i] = new LinkedList();
		}
	}

	// function to add edge to graph
	void addEdge(int startNode, int costNode)
	{
		adjacencyList[startNode].add(costNode);
		adjacencyList[costNode].add(startNode);
	}

	// A recursive function that uses visited[] and 
	// parent to detect cycle in subgraph reachable from vertex visitedNode.
	Boolean detectCycleDFS(int visitedNode, Boolean visited[], int parentNode)
	{
		// Mark the current node as visited
		visited[visitedNode] = true;
		Integer counter;

		// Recur for all the vertices
		// adjacent to this vertex
		Iterator<Integer> nodeIterator = adjacencyList[visitedNode].iterator();
		while (nodeIterator.hasNext()) 
		{
			counter = nodeIterator.next();

			// If an adjacent is not visited, 
			// then recur for that adjacent
			if (!visited[counter]) 
			{
				if (detectCycleDFS(counter, visited, visitedNode))
					return true;
			}

			// If an adjacent is visited and not parent of current vertex, 
			// then there is a cycle.
			else if (counter != parentNode)
			{
				return true;
			}
		}
		return false;
	}

	// return true if the graph contains a cycle
	// otherwise, return false 
	Boolean declareIfCyclic()
	{
		// mark all the vertices as not visited 
		// and not part of the recursion stack
		Boolean visited[] = new Boolean[numOfVertices];
		for (int iterations = 0; iterations < numOfVertices; iterations++)
		{
			visited[iterations] = false;
		}

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int node = 0; node < numOfVertices; node++) 
		{
			// Don't recur for node if already visited
			if (!visited[node]) 
			{
				if (detectCycleDFS(node, visited, -1)) 
				{
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[])
	{
		int numEdges, startNode, nodeCost;
    	Scanner userInput = new Scanner(System.in);

     	System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();
		undirectedGraphCycleDetection graph = new undirectedGraphCycleDetection(numEdges);

        while(numEdges != 0) 
		{
          numEdges = numEdges - 1;
          System.out.println("Enter the <start node> and the <cost node> : ");
          startNode = userInput.nextInt();
          nodeCost = userInput.nextInt();
          graph.addEdge(startNode,nodeCost);
        }

		if (graph.declareIfCyclic()) 
		{
			System.out.println("Graph contains cycle");
		}
		else
		{
			System.out.println("Graph doesn't contain cycle");
		}
	}
}

/*

Enter the number of edges in the graph: 5

1 , 0
0 , 2
2 , 1
0 , 3
3 , 4

Expected Output:
Graph contains cycle

 */