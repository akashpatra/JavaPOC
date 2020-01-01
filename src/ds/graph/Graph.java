package ds.graph;

import java.util.LinkedList;

/**
 * Basic Structure to Represent Graph.
 * <p>
 * FROM: GeeksForGeeks
 *
 * @author Akash Patra
 */
public class Graph {

    // No. of Vertices
    public int vertices;

    // Array of Lists for Adjacent List Representation (i.e., edge from node to node)
    public LinkedList<Integer> adj[];

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * Add an edge from v to w.
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
