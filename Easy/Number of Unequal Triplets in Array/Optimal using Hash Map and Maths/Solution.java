/*You are given a 0-indexed array of positive integers nums. Find the number of triplets (i, j, k) that meet the following conditions:

0 <= i < j < k < nums.length
nums[i], nums[j], and nums[k] are pairwise distinct.
In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
Return the number of triplets that meet the conditions.

 

Example 1:

Input: nums = [4,4,2,4,3]
Output: 3
Explanation: The following triplets meet the conditions:
- (0, 2, 4) because 4 != 2 != 3
- (1, 2, 4) because 4 != 2 != 3
- (2, 3, 4) because 2 != 4 != 3
Since there are 3 triplets, we return 3.
Note that (2, 0, 4) is not a valid triplet because 2 > 0.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: No triplets meet the conditions so we return 0.
 

Constraints:

3 <= nums.length <= 100
1 <= nums[i] <= 1000
 */



//Approach: 

/*Agar tumhare paas freq map ho — jisme har number ka frequency stored ho — toh:

Total triplets = nC3 = n * (n - 1) * (n - 2) / 6

Ab subtract karo wo triplets jisme at least two numbers same ho


You have 3 groups:
Group A: numbers to the left of current number
Group B: current number (middle)
Group C: numbers to the right of current number
So, for every unique number, use it as middle, and count:
total_triplets += count_left * count_current * count_right;


Because har triplet ke liye 3 different values chahiye → value_A, value_B, value_C.
Toh agar tum value_B ko fix kar do, toh:

Kitne elements usse pehle aaye (leftSum)

Kitne elements uske baad aayenge (rightSum)

Multiply all 3: left * current * right


nC3 - Invalid Combinations Approach
Step 1: Total Triplets = nC3

totalTriplets = n * (n-1) * (n-2) / 6
Step 2: Subtract all triplets jisme at least 2 elements same ho.
Let’s say koi number x occur hua hai freq times.

✅ If all 3 are same:
Triplets = freqC3

✅ If only 2 same, 1 different:
Fix 2 x's: freqC2 = freq * (freq-1) / 2

Multiply with (n - freq) = count of remaining values

Invalid triplets = freqC2 * (n - freq)

🔄 So, for each freq:

invalid += freqC3 + freqC2 * (n - freq)
valid = totalC3 - invalid
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
        
        System.out.println("Number of Unequal triplets are: "+unequalTriplets(arr));
        sc.close();
    }
    public static int unequalTriplets(int[] nums) {
        int result = 0, leftSum = 0, total = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:  nums)
        map.put(num, map.getOrDefault(num,0)+1);

        for (int freq : map.values()) {
            int rightSum = total - leftSum - freq;
            result += leftSum * freq * rightSum;
            leftSum += freq;
        }
        return result;
    }
}