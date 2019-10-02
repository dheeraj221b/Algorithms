import java.util.LinkedList;
import java.util.Queue;

/**
 * BFSTravelsal
 */
public class BFSTravelsal {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);

        bfsTraversal(g);
    }

    public static void bfsTraversal(Graph g) {
        LinkedList<Edge> graph[] = g.graph;

        // Starting traversal from 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean trackArr[] = new boolean[graph.length];
        trackArr[0] = true;

        while (!queue.isEmpty()) {
            int source = queue.remove();
            System.out.print(source + " ");

            LinkedList<Edge> list = graph[source];
            for (int i = 0; i < list.size(); i++) {
                int dest = list.get(i).dest;
                if (!trackArr[dest]) {
                    trackArr[dest] = true;
                    queue.add(dest);
                }
            }
        }
        System.out.println();
    }
}