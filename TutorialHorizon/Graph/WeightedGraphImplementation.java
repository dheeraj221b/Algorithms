/**
 * WeightedGraphImplementation
 */
public class WeightedGraphImplementation {

    // Adjacency Matrix Representaion
    static class GraphMatrix {
        int vertices;
        int graph[][];

        public GraphMatrix(int vertices) {
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

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        // GraphAdjacenecyList graph = new GraphAdjacenecyList(vertices);
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