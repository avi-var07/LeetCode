/*You are given an integer array nums.

Return an integer denoting the first even integer (earliest by array index) that appears exactly once in nums. If no such integer exists, return -1.

An integer x is considered even if it is divisible by 2.

 

Example 1:

Input: nums = [3,4,2,5,4,6]

Output: 2

Explanation:

Both 2 and 6 are even and they appear exactly once. Since 2 occurs first in the array, the answer is 2.

Example 2:

Input: nums = [4,4]

Output: -1

Explanation:

No even integer appears exactly once, so return -1.

 

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
        
        System.out.println(firstUniqueEven(arr));
        
        sc.close();
    }
    public static int firstUniqueEven(int[] nums) {
        Map<Integer, Integer>map = new HashMap<>();
        for(int ele: nums)map.put(ele, map.getOrDefault(ele,0)+1);

        for(int ele: nums)if(ele%2==0&&map.get(ele)==1)return ele;

        return -1;
    }

}