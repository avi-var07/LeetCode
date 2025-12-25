/*You are given an integer array nums of length n and a binary string s of the same length.

Initially, your score is 0. Each index i where s[i] = '1' contributes nums[i] to the score.

You may perform any number of operations (including zero). In one operation, you may choose an index i such that 0 <= i < n - 1, where s[i] = '0', and s[i + 1] = '1', and swap these two characters.

Return an integer denoting the maximum possible score you can achieve.

 

Example 1:

Input: nums = [2,1,5,2,3], s = "01010"

Output: 7

Explanation:

We can perform the following swaps:

Swap at index i = 0: "01010" changes to "10010"
Swap at index i = 2: "10010" changes to "10100"
Positions 0 and 2 contain '1', contributing nums[0] + nums[2] = 2 + 5 = 7. This is maximum score achievable.

Example 2:

Input: nums = [4,7,2,9], s = "0000"

Output: 0

Explanation:

There are no '1' characters in s, so no swaps can be performed. The score remains 0.

 

Constraints:

n == nums.length == s.length
1 <= n <= 105
1 <= nums[i] <= 109
s[i] is either '0' or '1'
 
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

        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(maximumScore(arr, s));
        sc.close();
    }
    public static long maximumScore(int[] nums, String s) {
        int n = nums.length;
        int one = 0;
        long ans=0;
        for(char ch: s.toCharArray())if(ch=='1')one++;

        if(one==0)return 0;

        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(s.charAt(i)=='1')ans+=pq.poll();
        }
        return ans;
    }
}