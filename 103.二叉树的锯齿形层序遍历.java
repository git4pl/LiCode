import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * */
class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        TreeNode node;

        while (true) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            while(!stack1.isEmpty()) {
                node = stack1.pop();
                tmp1.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }

            if (!tmp1.isEmpty()) {
                result.add(tmp1);
            } else {
                break;
            }

            ArrayList<Integer> tmp2 = new ArrayList<>();
            while(!stack2.isEmpty()) {
                node = stack2.pop();
                tmp2.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }

            if (!tmp2.isEmpty()) {
                result.add(tmp2);
            } else {
                break;
            }
        }
        return result;
    }
}
// @lc code=end

