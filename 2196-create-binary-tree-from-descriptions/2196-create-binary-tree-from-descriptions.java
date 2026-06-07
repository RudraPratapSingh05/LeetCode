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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal  = desc[1];
            int isLeft    = desc[2];

            // create nodes if they don't exist yet
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            // link child to parent
            if (isLeft == 1) {
                map.get(parentVal).left  = map.get(childVal);
            } else {
                map.get(parentVal).right = map.get(childVal);
            }

            // mark as child
            children.add(childVal);
        }

        // root is the node that never appeared as a child
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                return map.get(key);
            }
        }

        return null;
    }
}