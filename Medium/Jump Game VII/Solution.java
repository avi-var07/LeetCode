/*You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.

 

Example 1:

Input: s = "011010", minJump = 2, maxJump = 3
Output: true
Explanation:
In the first step, move from index 0 to index 3. 
In the second step, move from index 3 to index 5.
Example 2:

Input: s = "01101110", minJump = 2, maxJump = 3
Output: false
 

Constraints:

2 <= s.length <= 105
s[i] is either '0' or '1'.
s[0] == '0'
1 <= minJump <= maxJump < s.length
java */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        sc.close();
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n =s.length();
        Queue<Integer>queue = new LinkedList<>();
        boolean vis[]= new boolean[n];
        queue.add(0);
        vis[0]=true;

        int farthest =0;
        while(!queue.isEmpty()){
            int curr =queue.poll();
            if(curr==n-1)return true;

            //very slow: creates MLE/TLE
            // for(int i=curr+1;i<n;i++){
            //     if(curr+minJump<=i&&i<=Math.min(curr+maxJump, n-1)&&s.charAt(i)=='0'&&!vis[i]){
            //         queue.add(i);
            //         vis[i]=true;
            //     }
            // }
            //ek kaam krskte maximum jump bana k chlte hai:

            int start = Math.max(curr+minJump, farthest+1);
            int end =  Math.min(curr+maxJump, n-1);

            for(int i=start; i<=end;i++){
                if(!vis[i]&&s.charAt(i)=='0'){
                    vis[i]=true;
                    queue.add(i);
                }
                farthest=end;
            }
        }
        return false;
    }
}
