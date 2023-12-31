// detect a cycle in a DIRECTED graph using Depth First Search

import java.util.*;

class directedGraph
{
	private final int vertices;
	// create an adjacency list of the list of nodes
	private final List<List<Integer>> adjacencyList;

	// create an adjacency list for the graph
	// constructor class for the adjacency list of the graph 
	public directedGraph(int vertices)
	{
		this.vertices = vertices;
		adjacencyList = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++)
		{
			adjacencyList.add(new LinkedList<>());
		}
	}

	// Function to check if cycle exists
	private boolean detectCycleDFS(int i, boolean[] visitedNodes, boolean[] currentPath)
	{
		// Mark the current node as visited and
		// part of the stack for the current path of nodes it is visiting
		if (currentPath[i])
			return true;

		if (visitedNodes[i])
			return false;

		// set all the nodes that are visited, mark as true
		visitedNodes[i] = true;

		// set all the nodes that are in the current path 
		// of nodes being visited, mark as true
		currentPath[i] = true;
		List<Integer> children = adjacencyList.get(i);

		for (Integer child : children)
		{
			if (detectCycleDFS(child, visitedNodes, currentPath))
			{
				return true;
			}

		currentPath[i] = false;
		}

		return false;
	}

	private void addEdge(int sourceNode, int destinationNode)
	{
		adjacencyList.get(sourceNode).add(destinationNode);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	private boolean isCyclic()
	{
		// Mark all the vertices as not visited and
		// not part of the stack for currentPath 
		boolean[] visitedNodes = new boolean[vertices];
		boolean[] currentPath = new boolean[vertices];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < vertices; i++)
			if (detectCycleDFS(i, visitedNodes, currentPath))
				return true;
		
		return false;
	}

	public static void main(String[] args)
	{
		int numEdges, startNode, destinationNode;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the number of edges in the graph: ");
        numEdges = userInput.nextInt();
		directedGraph graph = new directedGraph(numEdges);

        while(numEdges != 0) 
        {
            numEdges = numEdges - 1;
            System.out.println("Enter the <start node> and its <connected node> : ");
            startNode = userInput.nextInt();
            destinationNode = userInput.nextInt();
            graph.addEdge(startNode,destinationNode);
        }

		// Function call to check if there is a cycle in the adjacency list for the graph
		if (graph.isCyclic())
		{
			System.out.println("Graph contains a cycle");
		}
		else
		{
			System.out.println("Graph does NOT contain a cycle");
		}
	}
}

/*
 	Enter the number of edges in the graph: 6
  
	0 , 1
	0 , 2
 	1 , 2
	2 , 0
 	2 , 3
 	3 , 3
*/
