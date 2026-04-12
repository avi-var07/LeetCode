/*You are given an integer array nums and an integer digit.

Return the total number of times digit appears in the decimal representation of all elements in nums.

 

Example 1:

Input: nums = [12,54,32,22], digit = 2

Output: 4

Explanation:

The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.

Example 2:

Input: nums = [1,34,7], digit = 9

Output: 0

Explanation:

The digit 9 does not appear in the decimal representation of any element in nums, so the total number of times digit 9 appears is 0.

 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 106​​​​​​​
0 <= digit <= 9 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter digit:  ");
        int digit = sc.nextInt();
        System.out.println(countDigitOccurrences(arr, digit));

        sc.close();
    }
    public static int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;
        for(int ele: nums){
            while(ele!=0){
                int d= ele%10;
                if(d==digit)ans++;
                ele/=10;
            }
        }   
        return ans;
    }
}