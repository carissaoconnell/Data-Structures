// undirected graph using nodes

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Graph {
private:
    unordered_map<string, vector<string>> verticiesList;
    vector<string> nodeOrder;

public:
    void addNode(string node) {
        verticiesList[node] = {};
        nodeOrder.push_back(node);
    }

    void addEdge(string node1, string node2) {
        verticiesList[node1].push_back(node2);
        verticiesList[node2].push_back(node1);
    }

    void printGraph() {
        for (auto& node : nodeOrder) {
            cout << node << " -> ";
            for (auto& neighbor : verticiesList[node]) {
                cout << neighbor << " ";
            }
            cout << endl;
        }
    }
};

int main() {
    Graph graph;
    int numNodes, numEdges;

    cout << "Enter the number of nodes: ";
    cin >> numNodes;

    for (int i = 0; i < numNodes; i++) {
        string node;
        cout << "Enter node " << i + 1 << ": ";
        cin >> node;
        graph.addNode(node);
    }

    cout << "Enter the number of edges: ";
    cin >> numEdges;

    for (int i = 0; i < numEdges; i++) {
        string node1, node2;
        cout << "Enter edge " << i + 1 << " (node1 node2): ";
        cin >> node1 >> node2;
        graph.addEdge(node1, node2);
    }

    cout << "Graph:" << endl;
    graph.printGraph();

    return 0;
}

/*

Enter the number of nodes: 5
Enter node 1: 0
Enter node 2: 1
Enter node 3: 2
Enter node 4: 3
Enter node 5: 4
Enter the number of edges: 4
Enter edge 1 (node1 node2): 0 1
Enter edge 2 (node1 node2): 1 2
Enter edge 3 (node1 node2): 2 3
Enter edge 4 (node1 node2): 3 4
Graph:
0 -> 1 
1 -> 0 2 
2 -> 1 3 
3 -> 2 4 
4 -> 3 

*/
