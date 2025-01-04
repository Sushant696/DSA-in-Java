package Graphs;

import java.util.ArrayList;
import linkedList.SingleLinkedlist;

class AdjList {

    private static SingleLinkedlist adjList[];
    private int vertices;

    public AdjList(int vertices) {
        this.vertices = vertices;
        adjList = new SingleLinkedlist[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new SingleLinkedlist();
        }
    }

    static void addEdges(int u, int v) {
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

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        addEdges(0, 1);
        addEdges(0, 2);
        addEdges(1, 3);
        addEdges(2, 3);
        addEdges(3, 4);
        adj.printGraph();
        ArrayList<Integer> res = adj.getAdjacentNode(0);
        System.out.println(res);

    }

}
