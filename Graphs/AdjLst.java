package Graphs;

import java.util.ArrayList;

public class AdjLst {

    int vertices;
    private static ArrayList<ArrayList<Integer>> list;
    // todo declaring the list as empty required

    public AdjLst(int vertices) {
        this.vertices = vertices;
        list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= vertices; i++) {
            list.add(new ArrayList<>());
        }
    }

    void addEdges(int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    ArrayList<Integer> getAdjacentNode(int i) {

        ArrayList<Integer> adjNodes = new ArrayList<>();
        for (int j = 0; j < list.get(i).size(); j++) {
            adjNodes.add(list.get(i).get(j));
        }
        for (Integer a : adjNodes) {
            System.out.println(a);
        }
        return adjNodes;
    }

    void printList() {
        for (int i = 0; i <= vertices; i++) {
            System.out.print(i + " is associated with => ");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        AdjLst lst = new AdjLst(5);
        lst.addEdges(0, 1);
        lst.addEdges(0, 2);
        lst.addEdges(1, 3);
        lst.addEdges(1, 4);
        lst.addEdges(2, 3);
        lst.addEdges(3, 4);
        lst.printList();
        lst.getAdjacentNode(0);
    }
}
