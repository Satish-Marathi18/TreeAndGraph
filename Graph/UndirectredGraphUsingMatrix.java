class UndirectedGraphUsingMatrix {
    private int vertex;
    private int[][] undirectedGraph;

    UndirectedGraphUsingMatrix(int vertex){
        this.vertex = vertex;
        this.undirectedGraph = new int[vertex][vertex];
    }

    public void addEdge(int src, int dest) {
        undirectedGraph[src][dest] = 1;
        undirectedGraph[dest][src] = 1;
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
        UndirectedGraphUsingMatrix graph1 = new UndirectedGraphUsingMatrix(3);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 1);
        graph1.displayGraph();
    }
}