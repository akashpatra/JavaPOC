package geekforgeeks.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Bread First Search or BFS in Graph for data which are not starting from zero.
 *
 * @author Akash Patra
 */
public class BFSAll {

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

    /**
     * Prints BFS traversal from given source s
     *
     * @param s
     */
    private void traverse(int s) {
        // Mark all the vertices as not visited (By default set as false)
        Map<Integer, Boolean> visited = new HashMap<>();

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited.put(s, true);
        queue.add(s);

        while (queue.size() != 0) {
            //
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> iterator = adj.get(s).listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited.getOrDefault(n, false)) {
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSAll bfs = new BFSAll();

        bfs.add(5, 6);
        bfs.add(5, 7);
        bfs.add(6, 7);
        bfs.add(7, 5);
        bfs.add(7, 8);
        bfs.add(8, 8);

        bfs.traverse(7);
    }
}
