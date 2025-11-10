/*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(sumSubarrayMins(arr));
        sc.close();
    }
    public static int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        Stack<Integer>st  = new Stack<>();
        int ns[] = new int[n];
        int ps[] = new int[n];
        int MOD = 1000000007;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])st.pop();
            ns[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i =0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])st.pop();
            ps[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        for(int i =0;i<n;i++){
            long left = i-ps[i];
            long right = ns[i]-i;

            long total = (arr[i]*left*right)%MOD;
            sum = (sum+total)%MOD;
        }
        return (int)(sum);
        
    }
}