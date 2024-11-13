import java.util.ArrayList;
import java.util.List;

public class DirectedGraphUsingList {
    private int vertices;
    private List<List<Integer>> undirectedGraph;
    
    DirectedGraphUsingList(int vertices){
        this.vertices=vertices;
        undirectedGraph = new ArrayList<>(vertices);

        for(int i=0; i<vertices; i++) {
            undirectedGraph.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        undirectedGraph.get(src).add(dest);
    }

    public void printGraph() {
        for(int i=0; i<vertices; i++){
            System.out.print("Vertex "+i+" is connected to : ");
            for(int edge : undirectedGraph.get(i)){
                System.out.print(edge+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraphUsingList graph = new DirectedGraphUsingList(3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.printGraph();
    }
}
