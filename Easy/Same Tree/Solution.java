/*Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
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
        System.out.println("Enter node (-1: stop) for tree 1: ");
        
        TreeNode root1 = buildTree(sc);

        
        System.out.println("Enter node (-1: stop) for tree 2: ");
        
        TreeNode root2 = buildTree(sc);

        System.out.println(isSameTree(root1, root2));
        
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
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null)return p==q;

        return (p.val==q.val)&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
}