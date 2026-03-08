/*Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.next();

        System.out.println(findDifferentBinaryString(arr));
        sc.close();
    }
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        // Set<Integer>set = new HashSet<>();
        // for(String ele: nums){
        //     int val = Integer.valueOf(ele,2);
        //     set.add(val);
        // }
        // int s =0;
        // for(int i=0;i<2*n;i++){
        //     if(!set.contains(i)){
        //         s=i;
        //         break;
        //     }
        // }
        //Approach1:
        //String bin = Integer.toBinaryString(s);
        //while(bin.length()<n)bin="0"+bin; 
        //return bin;

        //Approach 2:
        // String bin = Integer.toBinaryString(s);
        // StringBuilder sb=new StringBuilder();
        
        // for(int i=bin.length();i<n;i++)sb.append("0");
        // sb.append(bin);
        
        // return sb.toString();
        //Approach 3: Cantor's Diagonal Trick, har index i k liye ith element ki ith bit flip krk add krdo:

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)sb.append(nums[i].charAt(i)=='0'?'1':'0');
            
        return sb.toString();
        
    }
}