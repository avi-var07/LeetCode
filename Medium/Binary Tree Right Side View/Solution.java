/*Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */
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

        List<Integer>ans = sol.rightSideView(root);
        System.out.println(ans);
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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level=level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans =new ArrayList<>();
        if(root==null)return ans;
        Queue<Pair>queue = new LinkedList<>();
        Map<Integer, Integer>map = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode node = p.node;
            int level = p.level;

            map.put(level, node.val);
            if(node.left!=null)queue.add(new Pair(node.left, level+1));
            if(node.right!=null)queue.add(new Pair(node.right, level+1));
        }
        for(int ele: map.values())ans.add(ele);
        return ans;
    }
}