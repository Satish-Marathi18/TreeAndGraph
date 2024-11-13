package BFSandDFS;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjList[];

    public Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int d) {
        adjList[s].add(d);
    }

    public void BFS(int source) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source+" ");
            for(int n : adjList[source]) {
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(int source) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(source, visited);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] =true;
        System.out.print(vertex+" ");

        for(int v : adjList[vertex]){
            if(!visited[v]) {
                DFSUtil(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("BFS traversal starting from vertex 2: ");
        System.out.print("BFS :");
        graph.BFS(2);
        System.out.println();
        System.out.print("DFS :");
        graph.DFS(2);
    }
}
