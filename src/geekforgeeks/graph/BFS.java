package geekforgeeks.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Bread First Search or BFS in Graph
 *
 * @author Akash Patra
 */
public class BFS {

    // No. of Vertices
    private int V;

    // Adjacent Lists
    private LinkedList<Integer> adj[];

    // Constructor
    BFS(int v) {
        this.V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * Add an edge into the graph
     *
     * @param v
     * @param w
     */
    private void add(int v, int w) {
        adj[v].add(w);
    }

    /**
     * Prints BFS traversal from given source s
     *
     * @param s
     */
    private void traverse(int s) {

        // Mark all the vertices as not visited (By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            //
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {

                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(4);

        bfs.add(0, 1);
        bfs.add(0, 2);
        bfs.add(1, 2);
        bfs.add(2, 0);
        bfs.add(2, 3);
        bfs.add(3, 3);

        bfs.traverse(2);
    }
}
