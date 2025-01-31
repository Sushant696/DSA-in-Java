
public class DisjointSet {

    int size[];
    int parent[];
    int vertices;

    DisjointSet(int vertices) {
        this.vertices = vertices;
        size = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
    }

    void findCycle(int u, int v) {
        int uabsroot = find(u);
        int vabsroot = find(u);

        if (uabsroot == vabsroot) {
            System.out.println("Cycle detected");
        }
        // * add edge to graph (we are not creating the graph just suppose the graph is created)
        union(uabsroot, vabsroot);
    }

    void union(int uabsroot, int vabsroot) {
        if (size[uabsroot] > size[vabsroot]) {
            parent[vabsroot] = uabsroot;
        } else if (size[uabsroot] < size[vabsroot]) {
            parent[uabsroot] = size[vabsroot];
        } else {
            parent[uabsroot] = vabsroot;
            size[vabsroot]++;
        }
    }

    int find(int u) {
        if (parent[u] == -1) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(4);
        ds.findCycle(0, 1);
        ds.findCycle(1, 2);
        ds.findCycle(2, 4);
        // ds.findCycle(0,1);

    }
}
