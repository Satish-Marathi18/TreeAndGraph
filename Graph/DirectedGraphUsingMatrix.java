public class DirectedGraphUsingMatrix {
    private int vertex;
    private int[][] undirectedGraph;

    DirectedGraphUsingMatrix(int vertex){
        this.vertex = vertex;
        this.undirectedGraph = new int[vertex][vertex];
    }

    public void addEdge(int src, int dest) {
        undirectedGraph[src][dest] = 1;
    }

    public void displayGraph() {
        for(int i=0; i<undirectedGraph.length; i++){
            for(int j=0; j<undirectedGraph[i].length; j++) {
                System.out.print(undirectedGraph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraphUsingMatrix graph1 = new DirectedGraphUsingMatrix(3);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 0);
        graph1.addEdge(2, 0);
        graph1.displayGraph();
    }
}
