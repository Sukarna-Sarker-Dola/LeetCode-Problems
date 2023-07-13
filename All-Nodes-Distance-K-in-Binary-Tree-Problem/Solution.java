import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // Stores parent node for each node
        buildParentMap(root, null, parentMap); // Populate the parentMap

        // Perform DFS starting from the target node
        dfs(target, k, parentMap, result, null);

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        parentMap.put(node, parent); // Store the parent of the current node
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    private void dfs(TreeNode node, int k, Map<TreeNode, TreeNode> parentMap, List<Integer> result, TreeNode prev) {
        if (node == null) return;

        if (k == 0) {
            result.add(node.val); // Add the node to the result if it's at distance k
            return;
        }

        if (node.left != prev) {
            dfs(node.left, k - 1, parentMap, result, node); // Recurse on the left child
        }

        if (node.right != prev) {
            dfs(node.right, k - 1, parentMap, result, node); // Recurse on the right child
        }

        TreeNode parent = parentMap.get(node);
        if (parent != prev) {
            dfs(parent, k - 1, parentMap, result, node); // Recurse on the parent node
        }
        
    }
}