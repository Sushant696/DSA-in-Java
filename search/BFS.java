package search;

public class BFS {
    int vertices;
    int matrix[][];

    BFS(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    // cannot decide in the runtime as it will create circular dependency

    // boolean isDirected() {
    // assuming the graph isDirected
    // for (int i = 0; i < vertices; i++) {
    // for (int j = 0; j < vertices; j++) {
    // if (matrix[i][j] != matrix[j][i]) {
    // return true; // Directed graph
    // }
    // }

    // }
    // return false;
    // }

    void printGraph() {
        // printing the graph.
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " is connected to - ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BFS adjMatrix = new BFS(5);
        adjMatrix.addEdge(1, 2);
        adjMatrix.addEdge(3, 2);
        adjMatrix.addEdge(2, 1);
        adjMatrix.addEdge(3, 2);
        // adjMatrix.addEdge(1, 3);
        // adjMatrix.addEdge(3, 1);

        adjMatrix.printGraph();
        // boolean isDirect = adjMatrix.isDirected();
        // System.out.println(isDirect);
    }
}
