/*Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 
 */
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val=val;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter node (-1: stop): ");
        
        Solution  s = new Solution();
        TreeNode root = s.buildTree(sc);
        System.out.println(s.diameterOfBinaryTree(root));

        
        sc.close();
    }
    TreeNode buildTree(Scanner sc){

        int val = sc.nextInt();
        if(val==-1)return null;

        TreeNode root = new TreeNode(val);
        root.left=buildTree(sc);
        root.right=buildTree(sc);

        return root;
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
    int height(TreeNode node){
        if(node==null)return 0;
        int left = height(node.left);
        int right = height(node.right);
        ans = Math.max(ans, left+right);

        return 1+Math.max(left, right);
    }
}