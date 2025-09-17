/*You are given an integer array nums.

Return the smallest absent positive integer in nums such that it is strictly greater than the average of all elements in nums.

The average of an array is defined as the sum of all its elements divided by the number of elements.
 

Example 1:

Input: nums = [3,5]

Output: 6

Explanation:

The average of nums is (3 + 5) / 2 = 8 / 2 = 4.
The smallest absent positive integer greater than 4 is 6.
Example 2:

Input: nums = [-1,1,2]

Output: 3

Explanation:

​​​​​​​The average of nums is (-1 + 1 + 2) / 3 = 2 / 3 = 0.667.
The smallest absent positive integer greater than 0.667 is 3.
Example 3:

Input: nums = [4,-1]

Output: 2

Explanation:

The average of nums is (4 + (-1)) / 2 = 3 / 2 = 1.50.
The smallest absent positive integer greater than 1.50 is 2.
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100 */
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
        
        System.out.println("Smallest absent positive number greater than avg is: "+smallestAbsent(arr));
        sc.close();
    }

    public static int smallestAbsent(int[] nums) {
        int sum = 0;
        for(int ele: nums)sum+=ele;

        int avg = sum/nums.length;

        int ans = 1;

        while(true){
            if(ans>avg){
                boolean found = false;
                for(int ele: nums){
                    if(ele==ans){
                        found = true;
                        break;
                    }
                }
                if(!found)return ans;
            }
            ans++;
        }
    }
}