package Graphs;

import Queue.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class AdjMatrix {

    int[][] matrix;
    int vertices;

    public AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int u, int v, int w) {
        // bi directional connection between the two vertices connedted by edge
        matrix[u][v] = w;
        matrix[v][u] = w;
    }

    void BFS(int source) {
        Queue q = new Queue(vertices);
        boolean visited[] = new boolean[vertices];
        q.enqueue(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int x = q.dequeqe();
            System.out.println(x);

            // *call getAdjNodes and iterated through the list.
            for (int j = 0; j < vertices; j++) {
                if (matrix[x][j] != 0) {
                    if (!visited[j]) {
                        q.enqueue(j);
                        visited[j] = true;
                    }
                }
            }
        }

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

    int dijakstra(int source, int destination) {
        int dist[] = new int[vertices];
        int prevpath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }

        dist[source] = 0;

        for (int i = 0; i < vertices; i++) {
            int minvertex = findMinVertex(dist, visited);
            visited[minvertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (matrix[minvertex][j] != 0
                        && !visited[j] && dist[minvertex]
                        + matrix[minvertex][j] < dist[j]) {

                    dist[j] = dist[minvertex] + matrix[minvertex][j];
                    prevpath[j] = minvertex;
                }
            }
        }

        int x = destination;
        Stack<Integer> stk = new Stack<>();
        if (dist[x] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + source + " to " + destination);
            return -1;
        }
        stk.push(x);
        while (x != source) {
            x = prevpath[x];
            if (x == -1) {
                System.out.println("No path exists from " + source + " to " + destination);
                return -1;
            }
            stk.push(x);
        }
        System.out.print("Path: ");
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
        return dist[destination];

    }

    int findMinVertex(int[] dist, boolean[] visited) {
        int min = 0;
        for (int i = 0; i < vertices; i++) {
            if (min == -1 && !visited[i] || dist[i] < dist[min] && !visited[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(7);
        adj.addEdge(0, 1, 10);
        adj.addEdge(0, 5, 100);
        adj.addEdge(0, 2, 5);
        adj.addEdge(1, 2, 2);
        adj.addEdge(1, 3, 5);
        adj.addEdge(2, 3, 10);
        adj.addEdge(2, 4, 20);
        adj.addEdge(3, 5, 2);
        adj.addEdge(4, 5, 5);
        adj.printGraph();
        adj.BFS(0);
        adj.dijakstra(0, 5);
        System.out.println("hello world");
    }
}
