import java.util.*;

public class GraphPathChecker {

    // Graph represented as an adjacency list
    private Map<Integer, List<Integer>> graph;

    public GraphPathChecker() {
        graph = new HashMap<>();
    }

    // Add edge (undirected or directed depending on your use-case)
    public void addEdge(int src, int dest) {
        graph.putIfAbsent(src, new ArrayList<>());
        graph.putIfAbsent(dest, new ArrayList<>());
        graph.get(src).add(dest);

        // Uncomment the next line for an undirected graph
        // graph.get(dest).add(src);
    }

    // Method to check if a path exists using DFS
    public boolean hasPath(int start, int end) {
        Set<Integer> visited = new HashSet<>();
        return dfs(start, end, visited);
    }

    private boolean dfs(int current, int target, Set<Integer> visited) {
        if (current == target) return true;
        if (visited.contains(current)) return false;

        visited.add(current);

        List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (dfs(neighbor, target, visited)) {
                return true;
            }
        }

        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        GraphPathChecker graphChecker = new GraphPathChecker();

        // Example graph edges
        graphChecker.addEdge(0, 1);
        graphChecker.addEdge(1, 2);
        graphChecker.addEdge(2, 3);
        graphChecker.addEdge(4, 5);

        // Test cases
        System.out.println("Path between 0 and 3: " + graphChecker.hasPath(0, 3)); // true
        System.out.println("Path between 0 and 5: " + graphChecker.hasPath(0, 5)); // false
    }
}
