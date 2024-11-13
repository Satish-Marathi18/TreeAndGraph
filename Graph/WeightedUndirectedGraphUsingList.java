import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeightedUndirectedGraphUsingList {
    private int vertices;
    private List<List<Edge>> graph;

    class Edge{
        private int dest;
        private int weight;

        Edge(int dest, int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }

    WeightedUndirectedGraphUsingList(int vertices){
        this.vertices = vertices;
        graph = new ArrayList<>();

        for(int i=0; i<vertices; i++){  
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        graph.get(src).add(new Edge(dest, weight));
        graph.get(dest).add(new Edge(src, weight));
    }

    public void printGraph() {
        for(int i=0; i<vertices; i++){
            System.out.print("Vertex "+i+" is connected to: ");
            for(Edge edge : graph.get(i)){
                System.out.print("vertex: "+edge.dest+" with weight: "+edge.weight+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedUndirectedGraphUsingList graph = new WeightedUndirectedGraphUsingList(4);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 3, 9);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.printGraph();
    }
}
