package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * To detect cycle is present or not in a graph.
 * <p>
 * FROM: GeeksForGeeks
 * <p>
 * Time Complexity: O(V + E)
 *
 * @author Akash Patra
 */
public class CyclicGraph {

    private boolean isCyclicUtil(LinkedList adj[], int i, boolean[] recStack, boolean[] visited) {
        // This tells
        if (recStack[i]) {
            return true;
        }

        // This check is required to stop the process. Because, this tells that no cycle found from this node.
        if (visited[i]) {
            return false;
        }

        recStack[i] = true;
        visited[i] = true;

        Iterator<Integer> itr = adj[i].iterator();
        while (itr.hasNext()) {
            if (isCyclicUtil(adj, itr.next(), recStack, visited)) {
                return true;
            }
        }

        recStack[i] = false;

        return false;
    }

    private boolean isCyclic(LinkedList adj[], int v) {
        // Visited Array
        boolean[] visited = new boolean[v];

        // Recursive Stack Array
        boolean[] recStack = new boolean[v];

        for (int i = 0; i < v; i++) {
            return isCyclicUtil(adj, i, recStack, visited);
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);

        //
        CyclicGraph cyclicGraph = new CyclicGraph();
        boolean status = cyclicGraph.isCyclic(graph.adj, graph.vertices);

        if (status) {
            System.out.println("Cycle is Present");
        } else {
            System.out.println("Cycle is not Present");
        }

    }
}
