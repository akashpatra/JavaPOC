package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Akash Patra
 */
public class DFS1 {
    private LinkedList[] arr;
    private boolean visited[];

    DFS1(int vertices) {
        arr = new LinkedList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    private void DSFUtil(int sNode) {
        System.out.println(sNode);
        visited[sNode] = true;

        Iterator<Integer> itr = arr[sNode].iterator();
        int visitedNode;
        while (itr.hasNext()) {
            visitedNode = itr.next();
            if (!visited[visitedNode]) {
                DSFUtil(visitedNode);
            }
        }
    }

    private void addEdges(int s, int d) {
        try {
            arr[s].add(d);
            arr[d].add(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DFS1 dfs1 = new DFS1(5);
//        dfs1.addEdges(0, 1);
        dfs1.addEdges(0, 3);
//        dfs1.addEdges(1, 2);
//        dfs1.addEdges(1, 4);
        dfs1.addEdges(2, 3);
        dfs1.addEdges(4, 3);


        dfs1.DSFUtil(0);

    }
}
