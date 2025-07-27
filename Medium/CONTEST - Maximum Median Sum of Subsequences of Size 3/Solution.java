/*You are given an integer array nums with a length divisible by 3.

You want to make the array empty in steps. In each step, you can select any three elements from the array, compute their median, and remove the selected elements from the array.

The median of an odd-length sequence is defined as the middle element of the sequence when it is sorted in non-decreasing order.

Return the maximum possible sum of the medians computed from the selected elements.

 

Example 1:

Input: nums = [2,1,3,2,1,3]

Output: 5

Explanation:

In the first step, select elements at indices 2, 4, and 5, which have a median 3. After removing these elements, nums becomes [2, 1, 2].
In the second step, select elements at indices 0, 1, and 2, which have a median 2. After removing these elements, nums becomes empty.
Hence, the sum of the medians is 3 + 2 = 5.

Example 2:

Input: nums = [1,1,10,10,10,10]

Output: 20

Explanation:

In the first step, select elements at indices 0, 2, and 3, which have a median 10. After removing these elements, nums becomes [1, 10, 10].
In the second step, select elements at indices 0, 1, and 2, which have a median 10. After removing these elements, nums becomes empty.
Hence, the sum of the medians is 10 + 10 = 20.

 

Constraints:

1 <= nums.length <= 5 * 105
nums.length % 3 == 0
1 <= nums[i] <= 109 */


//Approach


/*🔍 Observations:
Median of 3 numbers is middle element after sorting:

median(a, b, c) = sorted([a, b, c])[1]

So hum chaahte hain ki har triplet ka median maximum ho taki total sum zyada bane.

Toh har step mein agar hum teen bade elements mein se median lein, toh wo zyada hoga.

💡 Strategy (Greedy Approach):
Sabse pehle array ko sort kar lo.

Ab socho ki agar array mein n elements hain, toh total n/3 steps honge.

Har step mein 3 elements hatane hain, toh humein har triplet ka median maximize karna hai.

Ek smart trick:
Sorted array se har step mein second-largest value uthao teen largest mein se (kyunki wohi median hoga).

Toh sorted array mein agar right se dekho:

Agar array: [1,1,2,2,3,3] → sorted ho gaya

Right se: 3,3,2,2,1,1

Triplet groups: (3,3,2), (2,1,1)

Medians: 3, 2 → Sum = 5 ✅

So basically, right se har 2nd element uthao har 3 size ke block ke liye.

✅ Final Steps (Algorithm):
Sort nums in ascending order.

Let n = nums.length

Initialize sum = 0

For i from n - 2 to n/3 with step -2, add nums[i] to sum.

Return sum

 */

 
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Maximum median sum of subsequence of size 3 is: "+maximumMedianSum(arr));
        sc.close();
    }
    public static long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long sum =0;
        int n = nums.length;
        for(int i = n-2;i>=n/3;i-=2)sum+=nums[i];

        return sum;
    }
}