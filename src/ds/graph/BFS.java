package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Breadth First Traversal
 * <p>
 * FROM: GeeksForGeeks
 *
 * @author Akash Patra
 */
public class BFS {

    Graph graph;

    private void start(int v) {
        boolean visited[] = new boolean[graph.vertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and add to queue
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            // Deque and print
            v = queue.poll();
            System.out.print(v + " ");

            // Get all adjacent nodes
            Iterator<Integer> iterator = graph.adj[v].iterator();
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
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        BFS dfs = new BFS();
        dfs.graph = graph;

        dfs.start(2);
    }
}
