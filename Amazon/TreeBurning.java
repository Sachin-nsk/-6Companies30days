/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxi = 0;
    public int amountOfTime(TreeNode root, int start) {
        traverse(root,start);
        return maxi;
    }

    public int traverse(TreeNode root , int start){
        int depth = 0;
        if(root == null) return depth;
        int leftDepth = traverse(root.left,start);
        int rightDepth = traverse(root.right,start);

        if(root.val==start){
            maxi = Math.max(leftDepth,rightDepth);
            depth = -1;
        }else if(leftDepth>=0 && rightDepth>=0){
            depth = Math.max(leftDepth,rightDepth)+1;
        }else{
            int dis = Math.abs(leftDepth)+Math.abs(rightDepth);
            maxi = Math.max(maxi,dis);
            depth = Math.min(leftDepth,rightDepth)-1;
        }
        return depth;
    }
}