package geekforgeeks.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Akash Patra
 */
public class DFS {

    //
    private Map<Integer, LinkedList<Integer>> adj = new HashMap<>();

    /**
     * Add an edge into the graph
     *
     * @param v
     * @param w
     */
    private void add(int v, int w) {
        adj.putIfAbsent(v, new LinkedList<>());
        adj.get(v).add(w);
    }

    private void DFSUtil(int v, Map<Integer, Boolean> visited) {

        // Mark the node as visited and print it
        visited.put(v, true);
        System.out.print(v + " ");

        // Rec all the vertices adjacent to the node
        Iterator<Integer> iterator = adj.get(v).listIterator();

        while (iterator.hasNext()) {
            int vTemp = iterator.next();
            if (!visited.getOrDefault(vTemp, false)) {
                DFSUtil(vTemp, visited);
            }
        }
    }

    private void traverse(int s) {
        // Mark all the vertices as not visited (By default set as false)
        Map<Integer, Boolean> visited = new HashMap<>();

        //
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();

        dfs.add(0, 1);
        dfs.add(0, 2);
        dfs.add(1, 2);
        dfs.add(2, 0);
        dfs.add(2, 3);
        dfs.add(3, 3);

        dfs.traverse(2);
    }
}
