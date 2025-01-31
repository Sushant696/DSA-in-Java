
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjMatrix {

    static class Edge implements Comparable<Edge> {

        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }

    }

    int[][] matrix;
    int vertices;

    Edge[] edges; //* */ mst 
    int edgeIndx = -1; //* */ mst

    public AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
        edges = new Edge[vertices * (vertices - 1) / 2];

    }

    void addEdge(int u, int v, int w) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        edges[++edgeIndx] = new Edge(u, v, w);
    }

// kruskalsAlgorithm in exam  take the necessary stuff like vertices and edges and do stuff 
// * mst start
    void kruskalsAlgorithm() {
        int parent[] = new int[vertices];
        int size[] = new int[vertices];
        int mst[][] = new int[vertices][vertices]; // mst in adj mtx
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        Arrays.sort(edges);
        int edgeTaken = 0;
        int edgeCounter = -1;
        while (edgeTaken < vertices) {
            Edge e = edges[++edgeCounter]; // storing edge
            int uabsroot = find(e.u, parent);
            int vabsroot = find(e.v, parent);

            if (uabsroot == vabsroot) {
                continue;
            }
            mst[e.u][e.v] = e.w;
            mst[e.v][e.u] = e.w;
            union(uabsroot, vabsroot, size, parent);
            edgeTaken++;
        }
    }

    void union(int uabsroot, int vabsroot, int size[], int parent[]) {
        if (size[uabsroot] > size[vabsroot]) {
            parent[vabsroot] = uabsroot;
        } else if (size[uabsroot] < size[vabsroot]) {
            parent[uabsroot] = size[vabsroot];
        } else {
            parent[uabsroot] = vabsroot;
            size[vabsroot]++;
        }
    }

    int find(int u, int parent[]) {
        if (parent[u] == -1) {
            return u;
        }
        return parent[u] = find(parent[u], parent);
    }

// * mst end 
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
        AdjMatrix mtx = new AdjMatrix(5);
        // mtx.addEdge(1, 2);
        // mtx.addEdge(1, 3);
        // mtx.addEdge(2, 4);
        // mtx.addEdge(3, 4);
        // mtx.addEdge(2, 5);
        // mtx.addEdge(4, 5);
        // mtx.printMatrix();
        mtx.getAdjacentNode(2);
    }
}
