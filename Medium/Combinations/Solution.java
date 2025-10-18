/*Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter value of n: ");
        int n = sc.nextInt();
        System.out.println("Enter value of k: ");
        int k = sc.nextInt();
        List<List<Integer>>list = combine(n, k);
        for(var ele: list)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        generate(n,k,ds,ans, 1);
        return ans;
    }
    static void generate(int n, int k, List<Integer> ds, List<List<Integer>>ans, int index){
        if(k==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<=n;i++){
            ds.add(i);
            generate(n,k-1,ds,ans, i+1);
            ds.remove(ds.size()-1);
           
            

        }
    }
}