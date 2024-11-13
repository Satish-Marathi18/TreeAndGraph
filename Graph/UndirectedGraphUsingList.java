import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphUsingList {
    private int vertices;
    private List<List<Integer>> undirectedGraph;
    
    UndirectedGraphUsingList(int vertices){
        this.vertices=vertices;
        undirectedGraph = new ArrayList<>(vertices);

        for(int i=0; i<vertices; i++) {
            undirectedGraph.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        undirectedGraph.get(src).add(dest);
        undirectedGraph.get(dest).add(src);
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
        UndirectedGraphUsingList graph = new UndirectedGraphUsingList(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.printGraph();
    }
}
