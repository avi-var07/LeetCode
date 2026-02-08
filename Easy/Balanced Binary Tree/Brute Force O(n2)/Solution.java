/*Given a binary tree, determine if it is height-balanced.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104 */
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
        
        TreeNode root = buildTree(sc);

        System.out.println(isBalanced(root));
        sc.close();
    }
    static TreeNode buildTree(Scanner sc){

        int val = sc.nextInt();
        if(val==-1)return null;

        TreeNode root = new TreeNode(val);
        root.left=buildTree(sc);
        root.right=buildTree(sc);

        return root;
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null)return true;

        int lHeight = height(root.left);
        int rHeight = height(root.right);
        if(Math.abs(lHeight-rHeight)>1)return false;

        return isBalanced(root.left)&&isBalanced(root.right);
    }
    static int height(TreeNode node){
        if(node==null)return 0;

        return 1+Math.max(height(node.left),height(node.right));
    }
}