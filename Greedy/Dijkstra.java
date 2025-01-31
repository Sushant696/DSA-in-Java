package Greedy;

import java.util.Stack;

public class Dijkstra {

    /*
     * What are the requirement:
     * 1. we need adjacency matrix at first
     * 
     * Then a function with source and destination
     * 
     * we need prevPath array to know the shorted path that we have traveled
     * visited array to track which items are visited and which are not
     * 
     * steps :
     * populate the dist with infinite value and the prev path with -1
     * 
     * starting with source index in the dist array with value 0
     * 
     * check fo the minimum vertex from the source and mark as visited
     * 
     * Then do the relaxation thing
     * 
     */
    int vertices;
    int matrix[][];

    Dijkstra(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int u, int v, int w) {
        matrix[u][v] = w;
        matrix[v][u] = w;
    }

    void printGraph() {

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to -> ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(j);

                }
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
            // * find minimum vertex
            int min_vertex = findMinVertex(dist, visited);
            visited[min_vertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && matrix[min_vertex][j] != 0 && dist[min_vertex] + matrix[min_vertex][j] < dist[j]) {
                    dist[j] = dist[min_vertex] + matrix[min_vertex][j];
                    prevpath[j] = min_vertex;

                }
            }

        }
        // print path
        int x = destination;
        // Stack stk = new Stack(vertices);
        Stack<Integer> stk = new Stack<>();
        stk.push(x);
        while (prevpath[x] != -1) {
            x = prevpath[x];
            stk.push(x);
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop());
        }
        return dist[destination];
    }

    // * always choosing unvisited neighbour with minimum vertex
    int findMinVertex(int[] dist, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (min == -1 || dist[i] < dist[min])) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Dijkstra djk = new Dijkstra(7);
        djk.addEdge(0, 1, 10);
        djk.addEdge(0, 2, 5);
        djk.addEdge(0, 5, 1000);
        djk.addEdge(1, 2, 2);
        djk.addEdge(1, 3, 5);
        djk.addEdge(2, 3, 10);
        djk.addEdge(2, 4, 20);
        djk.addEdge(3, 5, 2);
        djk.addEdge(4, 5, 5);
        // djk.printGraph();
        djk.dijakstra(1, 4);
    }
}
