import java.util.*;

public class CycleDetectionUndirectedGraph {
    private Map<Integer, List<Integer>> graph;

    public CycleDetectionUndirectedGraph() {
        graph = new HashMap<>();
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Detect cycle in the graph
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                // Pass -1 as parent for the root node
                if (dfs(node, visited, -1)) {
                    return true; // cycle found
                }
            }
        }

        return false; // no cycle
    }

    // DFS helper for cycle detection
    private boolean dfs(int current, Set<Integer> visited, int parent) {
        visited.add(current);

        for (int neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If neighbor is visited and not parent, cycle exists
                return true;
            }
        }

        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CycleDetectionUndirectedGraph graph = new CycleDetectionUndirectedGraph();

        // Graph with a cycle: 0-1-2-0
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println("Graph contains cycle? " + graph.hasCycle()); // true

        // Graph without a cycle
        CycleDetectionUndirectedGraph graph2 = new CycleDetectionUndirectedGraph();
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(3, 4);

        System.out.println("Graph contains cycle? " + graph2.hasCycle()); // false
    }
}
