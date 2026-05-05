/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
  */

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

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println(sol.kthSmallest(root, k));
        
        sc.close();
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null)return new TreeNode(val);

        if(root.val<val)root.right =insert(root.right, val);
        else root.left=insert(root.left, val);

        return root;

    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k-1);
    }
    void inorder(TreeNode root, List<Integer>list){
        if(root==null)return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
}