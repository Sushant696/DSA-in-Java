package Graphs;

import java.util.ArrayList;
import java.util.List;

class AdjMatrix {

    int[][] matrix;
    int vertices;

    public AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdges(int u, int v) {

// bi directional connection between the two  vertices connedted by edge 
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to  ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] != 0) // connection found between i and j
                {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();

        }
    }

    List<Integer> getAdjNode(int i) {
        List<Integer> adjNodes = new ArrayList<>();

        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] != 0) // connection found between i and j
            {
                adjNodes.add(j);
            }
        }

        // printing the adjNotes
        for (Integer integer : adjNodes) {
            System.out.println(integer);
        }
        return adjNodes;
    }

    void printMatrix() {
        // print row by row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();
        System.out.println("hello world");
    }

}
