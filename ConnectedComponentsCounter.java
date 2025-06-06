import java.util.*;

public class ConnectedComponentsCounter {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

    public ConnectedComponentsCounter() {
        graph = new HashMap<>();
        visited = new HashSet<>();
    }

    // Add an undirected edge between u and v
    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Count connected components in the graph
    public int countConnectedComponents() {
        int count = 0;
        visited.clear();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node);
                count++;
            }
        }

        return count;
    }

    // DFS traversal to mark all nodes in a component
    private void dfs(int node) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ConnectedComponentsCounter graph = new ConnectedComponentsCounter();

        // Example graph:
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        // This graph has 2 connected components: {0,1,2} and {3,4}
        System.out.println("Number of connected components: " + graph.countConnectedComponents());
    }
}
