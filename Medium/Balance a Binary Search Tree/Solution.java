/*Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105 */
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
        
        TreeNode root = buildTreeDefault(sc);
        
        TreeNode ans = balanceBST(root);

        List<Integer>list = new ArrayList<>();
        inorder(ans, list);

        for(int ele: list)System.out.print(ele+" ");
        sc.close();
    }
    static TreeNode buildTreeDefault(Scanner sc){

        int val = sc.nextInt();
        if(val==-1)return null;

        TreeNode root = new TreeNode(val);
        root.left=buildTreeDefault(sc);
        root.right=buildTreeDefault(sc);

        return root;
    }
    public static TreeNode balanceBST(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        return buildTree(list, 0, n-1);
    }
    static void inorder(TreeNode root, List<Integer>list){
        if(root==null)return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
    static TreeNode buildTree(List<Integer>list, int start, int end){
        if(start>end)return null;

        int mid = start+(end-start)/2;

        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildTree(list, start, mid-1);
        node.right = buildTree(list, mid+1, end);

        return node;
    }
}