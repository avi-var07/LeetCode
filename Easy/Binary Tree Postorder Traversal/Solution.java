/* Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
class Solution {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    static void postorder(TreeNode root, List<Integer>ans){
        if(root==null)return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
    static TreeNode buildTree(Scanner sc){
        int val = sc.nextInt();

        if(val==-1)return null;

        TreeNode root= new TreeNode(val);

        root.left=buildTree(sc);
        root.right=buildTree(sc);

        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes: (-1 for stop)");
        TreeNode root = buildTree(sc);

        List<Integer> res = postorderTraversal(root);

        for(int ele: res)System.out.print(ele+" ");
        sc.close();
    }
}   
