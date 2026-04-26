/*You are given an integer array nums.

An element nums[i] is considered valid if it satisfies at least one of the following conditions:

It is strictly greater than every element to its left.
It is strictly greater than every element to its right.
The first and last elements are always valid.

Return an array of all valid elements in the same order as they appear in nums.

 

Example 1:

Input: nums = [1,2,4,2,3,2]

Output: [1,2,4,3,2]

Explanation:

nums[0] and nums[5] are always valid.
nums[1] and nums[2] are strictly greater than every element to their left.
nums[4] is strictly greater than every element to its right.
Thus, the answer is [1, 2, 4, 3, 2].
Example 2:

Input: nums = [5,5,5,5]

Output: [5,5]

Explanation:

The first and last elements are always valid.
No other elements are strictly greater than all elements to their left or to their right.
Thus, the answer is [5, 5].
Example 3:

Input: nums = [1]

Output: [1]

Explanation:

Since there is only one element, it is always valid. Thus, the answer is [1].

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<Integer>ans = new ArrayList<>();
        for(int ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<Integer> findValidElements(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        int n =nums.length;
        if(n==1){
            ans.add(nums[0]);
            return ans;
        }

        int leftMax[] = new int [n];
        int rightMax[] = new int [n];

        leftMax[0]=Integer.MIN_VALUE;
        rightMax[n-1]=Integer.MIN_VALUE;

        for(int i=1;i<n;i++)leftMax[i]=Math.max(leftMax[i-1], nums[i-1]);
        for(int i=n-2;i>=0;i--)rightMax[i]=Math.max(rightMax[i+1], nums[i+1]);

        for(int i=0;i<n;i++){
            if(nums[i]>leftMax[i]||nums[i]>rightMax[i])ans.add(nums[i]);
        }

        return ans;
    }
}