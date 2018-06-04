package structures;

import java.util.*;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphStructure {
    Map<Integer, List<Integer>> root;

    class Edge {
        private int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object obj) {
            Edge e = (Edge)obj;
            return this.src == e.src && this.dest == e.dest;
        }
    }

    public GraphStructure() {
        root = new HashMap<>();
    }

    public void addEdge(Edge edge) {
        List<Integer> edges = root.get(edge.src);
        if(edges == null) {
            edges = new ArrayList<Integer>();
            root.put(edge.src, edges);
        }
        edges.add(edge.dest);

        List<Integer> destEdges = root.get(edge.dest);
        if(destEdges == null) {
            destEdges = new ArrayList<>();
            root.put(edge.src, destEdges);
        }
        destEdges.add(edge.src);

    }

    public void bfsIterative(int vertex) throws Exception {
        if(root.get(vertex) == null) throw new Exception("Vertex not found");
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            System.out.print(vertex + " ");

            List<Integer> edges = root.get(vertex);
            for (Integer i : edges) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    queue.add(i);
                }
            }

        }
        System.out.println("\n");
    }

    public void dfsIterative(int vertex) throws Exception {
        if(root.get(vertex) == null) throw new Exception("No such vertex");
        Map<Integer, Integer> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        visited.put(vertex, 1);
        stack.add(vertex);

        while (!stack.empty()) {
            vertex = stack.pop();
            System.out.println(vertex + " ");

            List<Integer> edges = new ArrayList<>();
            for (Integer i : edges) {
                if(visited.get(i) == null) {
                    visited.put(i, 1);
                    stack.add(i);
                }
            }
        }
        System.out.println("\n");
    }

    public void dfsRecursive(int vertex) throws Exception {
        if(root.get(vertex) == null) throw new Exception("Vertex not found");
        Map<Integer, Integer> visited = new HashMap<>();
        dfsUtil(vertex, visited);
        System.out.println("\n");
    }

    private void dfsUtil(int vertex, Map<Integer, Integer> visited) {
        visited.put(vertex, 1);
        System.out.println(vertex + " ");
        List<Integer> edges = root.get(vertex);

        for (Integer i : edges) {
            if(visited.get(i) == null) {
                dfsUtil(i, visited);
            }
        }
    }
}
