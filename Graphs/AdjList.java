package Graphs;

import java.util.ArrayList;
import linkedList.SingleLinkedlist;

class AdjList {

    // todo this is linked where each element is vertex and represent a single linked list.
    private SingleLinkedlist adjList[];
    private int vertices;

    public AdjList(int vertices) {
        this.vertices = vertices;
        adjList = new SingleLinkedlist[vertices];
        // initialize the adjList then instantiate

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new SingleLinkedlist();
        }
    }

    void addEdges(int u, int v) {
        // it's undirected adj list
        adjList[u].addNode(v);
        adjList[v].addNode(u);
    }

    public ArrayList<Integer> getAdjacentNode(int i) {
        ArrayList<Integer> adjNodes = new ArrayList<>();
        SingleLinkedlist.Node current = adjList[i].head;
        while (current != null) {
            adjNodes.add(current.data);
            current = current.next;
        }
        return adjNodes;
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            // selecting the sub array (row) 
            System.out.println(i + "is connected to ");
            SingleLinkedlist.Node current = adjList[i].head;

            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    void depthFirstSearch(int source) {
        boolean visited[] = new boolean[vertices];
        DFS(source, visited);
    }

    void DFS(int rootNode, boolean visited[]) {
        System.out.println(rootNode);
        visited[rootNode] = true;

        // * get adjnodes and traverse through list
        SingleLinkedlist.Node current = adjList[rootNode].head;
        while (current != null) {
            if (!visited[current.data]) {
                DFS(current.data, visited);
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        // adj.printGraph();
        ArrayList<Integer> res = adj.getAdjacentNode(0);
        adj.depthFirstSearch(0);
    }

}

// for (int j = 0; j < list.get(rootNode).size(); j++) {
//     int adjNode = list.get(rootNode).get(j);
//     if (!visited[adjNode]) {
//         DFS(adjNode, visited);
//     }
// }
