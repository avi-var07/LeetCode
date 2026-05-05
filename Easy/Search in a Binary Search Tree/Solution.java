/*You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107 */

import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;

    int val;

    TreeNode(int val){
        this.val=val;
    }
}
class Solution{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        TreeNode root=null;

        System.out.println("Enter "+n+" Elements: ");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            root=sol.insert(root, val);
        }

        System.out.println("Enter key to search: ");
        int key = sc.nextInt();

        TreeNode ans = sol.searchBST(root, key);

        if(ans==null)System.out.println("Not Found! ");
        else sol.inorder(ans);
        sc.close();
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return root;
        if(root.val==val)return root;

        if(root.val<val)return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null)return new TreeNode(val);

        if(root.val<val)root.right =insert(root.right, val);
        else root.left=insert(root.left, val);

        return root;

    }
    public void inorder(TreeNode root){
        if(root==null)return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);

    }
}