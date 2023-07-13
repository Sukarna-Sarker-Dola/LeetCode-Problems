import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // Create the adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Check for cycle using DFS
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited, recursionStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int course, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[course]) {
            // If we encounter a node in the recursion stack, there is a cycle
            return true;
        }

        if (visited[course]) {
            // If we have already visited this node and there is no cycle, return false
            return false;
        }

        visited[course] = true;
        recursionStack[course] = true;

        for (int prerequisiteCourse : graph.get(course)) {
            if (hasCycle(graph, prerequisiteCourse, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[course] = false; // Remove the course from the recursion stack
        return false;
        
    }
}