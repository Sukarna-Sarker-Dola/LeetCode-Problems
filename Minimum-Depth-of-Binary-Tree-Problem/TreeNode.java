//Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
 }
 
class Solution {
    public int minDepth(TreeNode root) {
        // Check if the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Check if the root is a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // Calculate the minimum depth of the left and right subtrees
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // Check for cases with only one child
        if (root.left == null || root.right == null) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        
        // Return the minimum depth of the left and right subtrees plus 1
        return Math.min(leftDepth, rightDepth) + 1;
    }
}