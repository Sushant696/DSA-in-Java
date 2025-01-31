
import Queue.Queue;

public class TopologicalSorting {

    int count = 0;

    int TopoSort(int adjMatrix[][], int v) {
        int indegree[] = new int[v];
        Queue q = new Queue(v);

        // calc degree
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adjMatrix[i][j] == 0) {
                    indegree[j]++;
                }
            }
        }

// put the items in the queue
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.enqueue(i);
            }
        }

        while (!q.isEmpty()) {
            count++;
            int x = q.dequeqe();
            System.out.println(x);

            // find and substract the indegree of those who are connected with that x 
            for (int j = 0; j < v; j++) {
                if (adjMatrix[x][j] != 0) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        q.dequeqe();
                    }
                }
            }
        }

        if (count != v) {
            System.out.println("cycle detected ");
            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
