package search;

import linkedList.SingleLinkedlist;

public class DFS {

    int vertices;
    SingleLinkedlist list[];

    public DFS(int vertices) {
        this.vertices = vertices;
        list = new SingleLinkedlist[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new SingleLinkedlist();
        }
    }

    void addEdge(int u, int v) {
        list[u].addNode(v);
        list[v].addNode(u);
    }

    void getAdjacentNode(int i) {
        // i have the row i mean linked list head or thing to access the linked list
        SingleLinkedlist.Node current = list[i].head;
        while (current != null) {
            System.out.println(current.data);
        }
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to => ");
            SingleLinkedlist.Node current = list[i].head;
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;

            }
            System.out.println();
        }

    }

    void DepthFirstSearch(int source) {
        //
        boolean visited[] = new boolean[vertices];
        dfs(source, visited);
    }

    void dfs(int root, boolean visited[]) {
        System.out.println(root);
        visited[root] = true;
        SingleLinkedlist.Node current = list[root].head;

        while (current != null) {
//* */ now we are iterating the linked list

            if (!visited[current.data]) {
                dfs(current.data, visited);
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DFS adj = new DFS(5);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(1, 3);
        adj.addEdge(1, 4);
        adj.addEdge(2, 3);
        adj.addEdge(3, 4);
        // adj.printGraph();
        adj.DepthFirstSearch(1);
    }

}
