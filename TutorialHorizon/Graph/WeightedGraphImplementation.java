import java.util.LinkedList;

/**
 * WeightedGraphImplementation
 */
public class WeightedGraphImplementation {

    // Adjacency Matrix Representaion
    static class Graph {
        int vertices;
        int graph[][];

        public Graph(int vertices) {
            this.vertices = vertices;
            graph = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination, int weight) {
            graph[source][destination] = weight;
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (graph[i][j] != 0) {
                        System.out.println("Vertex " + i + " is connected to " + j + " with weight " + graph[i][j]);
                    }
                }
            }
        }
    }

    // Adjacency List Representation
    static class GraphAdjacenecyList {
        int vertices;
        LinkedList<Edge> graph[];

        public GraphAdjacenecyList(int vertices) {
            this.vertices = vertices;
            graph = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                graph[i] = new LinkedList<Edge>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            graph[source].add(new Edge(source, destination, weight));
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = graph[i];
                for (int j = 0; j < list.size(); j++) {
                    Edge e = list.get(j);
                    System.out
                            .println("Vertex " + e.source + " is connected to " + e.dest + " with weight " + e.weight);
                }
            }
        }
    }

    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        // Graph graph = new Graph(vertices);
        GraphAdjacenecyList graph = new GraphAdjacenecyList(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        graph.printGraph();
    }
}