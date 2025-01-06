package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjMtx {

    int[][] matrix;
    int vertices;

    public AdjMtx(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices + 1][vertices + 1];
    }

    void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    void printMatrix() {
        // print row by row
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    void getAdjacentNode(int i) {
        // todo adjacent nodes means vertices that are adjacent
        List<Integer> adjNodes = new ArrayList<>();
        for (int j = 0; j <= vertices; j++) {
            if (matrix[i][j] != 0) {
                System.out.println(i + "" + j);
                adjNodes.add(j);
            }

        }
    }

    public static void main(String[] args) {

        // Todo we are asuming 1-based index so  
        AdjMtx mtx = new AdjMtx(5);
        mtx.addEdge(1, 2);
        mtx.addEdge(1, 3);
        mtx.addEdge(2, 4);
        mtx.addEdge(3, 4);
        mtx.addEdge(2, 5);
        mtx.addEdge(4, 5);
        // mtx.printMatrix();
        mtx.getAdjacentNode(2);
    }
}
