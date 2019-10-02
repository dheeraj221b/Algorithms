import java.util.LinkedList;

class Edge {
    int source;
    int dest;
    int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

// Adjacency List Representation
class Graph {
    int vertices;
    LinkedList<Edge> graph[];

    public Graph(int vertices) {
        this.vertices = vertices;
        graph = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<Edge>();
        }
    }

    public void addEdge(int source, int destination) {
        addEdge(source, destination, 0);
    }

    public void addEdge(int source, int destination, int weight) {
        graph[source].add(new Edge(source, destination, weight));
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = graph[i];
            for (int j = 0; j < list.size(); j++) {
                Edge e = list.get(j);
                System.out.println("Vertex " + e.source + " is connected to " + e.dest + " with weight " + e.weight);
            }
        }
    }
}