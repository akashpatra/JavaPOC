package ds.graph;

import java.util.Iterator;

/**
 * Depth First Traversal
 * <p>
 * FROM: GeeksForGeeks
 *
 * @author Akash Patra
 */
public class DFS {

    Graph graph;

    private void start(int v) {
        boolean visited[] = new boolean[graph.vertices];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = graph.adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
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

        DFS dfs = new DFS();
        dfs.graph = graph;

        dfs.start(2);
    }
}
