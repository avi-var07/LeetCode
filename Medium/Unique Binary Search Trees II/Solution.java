/* Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8*/

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
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        
        List<TreeNode>ans = sol.generateTrees(n);

        for(TreeNode ele: ans)System.out.print(ele+" ");

        
        sc.close();
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new ArrayList<>();
        return generate(1,n);
    }
    List<TreeNode>generate(int start, int end){
        List<TreeNode>list = new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode>left = generate(start, i-1);
            List<TreeNode>right = generate(i+1, end);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left=l;
                    root.right=r;

                    list.add(root);
                }
            }

        }
        return list;
    }
}