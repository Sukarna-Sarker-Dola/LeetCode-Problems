import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         int n = graph.length;
        int[] colors = new int[n]; // Node colors: 0 (white) - not processed, 1 (gray) - in processing, 2 (black) - processed
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafeNode(i, graph, colors)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSafeNode(int node, int[][] graph, int[] colors) {
        if (colors[node] > 0) {
            return colors[node] == 2; // Return true if the node is already processed (black)
        }

        colors[node] = 1; // Mark the node as in processing (gray)

        for (int neighbor : graph[node]) {
            if (!isSafeNode(neighbor, graph, colors)) {
                return false; // Return false if a neighbor is not a safe node
            }
        }

        colors[node] = 2; // Mark the node as processed (black)
        return true;
        
    }
}