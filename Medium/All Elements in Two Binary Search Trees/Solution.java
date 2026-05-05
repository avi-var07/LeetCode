/* */

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
        System.out.println("Enter number of Elements of first BST: ");
        int m = sc.nextInt();
        System.out.println("Enter number of Elements of second BST: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        TreeNode root1=null;
        TreeNode root2=null;

        System.out.println("Enter "+m+" Elements of first BST: ");
        for(int i=0;i<m;i++){
            int val = sc.nextInt();
            root1=sol.insert(root1, val);
        }
        System.out.println("Enter "+n+" Elements of second BST: ");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            root2=sol.insert(root2, val);
        }

        List<Integer>ans = sol.getAllElements(root1, root2);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null)return new TreeNode(val);

        if(root.val<val)root.right =insert(root.right, val);
        else root.left=insert(root.left, val);

        return root;

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    
    //Brute Force:

    //     List<Integer>ans= new ArrayList<>();
    //     ans.addAll(inorder(root1)); //poori list add krni hai, wrna ek aur list lo use add kro, bekar!!
    //     ans.addAll(inorder(root2));
    //     Collections.sort(ans);
    //     return ans;
    // }
    // List<Integer>inorder(TreeNode root){
    //     List<Integer>list = new ArrayList<>();
    //     if(root==null)return list;

    //     list.addAll(inorder(root.left));
    //     list.add(root.val);
    //     list.addAll(inorder(root.right));

    //     return list;

    //Optimal: BST already sorted, just inorder+merge

    List<Integer>list1 = new ArrayList<>();
    List<Integer>list2 = new ArrayList<>();

    inorder(root1, list1);
    inorder(root2, list2);

    return merge(list1, list2);


    }

    void inorder(TreeNode root, List<Integer>list){
        if(root==null)return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    List<Integer>merge(List<Integer>list1, List<Integer>list2){

        int i=0;
        int j=0;

        List<Integer>ans = new ArrayList<>();
        int m =list1.size();
        int n =list2.size();
        while(i<m&&j<n){
            if(list1.get(i)<list2.get(j))ans.add(list1.get(i++));
            else ans.add(list2.get(j++));
        }

        while(i<m)ans.add(list1.get(i++));
        while(j<n)ans.add(list2.get(j++));

        return ans;
    }
}