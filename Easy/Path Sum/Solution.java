/*Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000 */
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
        
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        System.out.println(hasPathSum(root, target));
        
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
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;

        if(root.left==null&&root.right==null)return targetSum==root.val; //leaf node check kro-> hai to sum barabar hua present value add krk?


        int remaining = targetSum-root.val;
        return hasPathSum(root.left, remaining)||hasPathSum(root.right, remaining);

    }
}