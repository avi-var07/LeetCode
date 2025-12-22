/*You are given an integer array nums.

In one operation, you remove the first three elements of the current array. If there are fewer than three elements remaining, all remaining elements are removed.

Repeat this operation until the array is empty or contains no duplicate values.

Return an integer denoting the number of operations required.

 

Example 1:

Input: nums = [3,8,3,6,5,8]

Output: 1

Explanation:

In the first operation, we remove the first three elements. The remaining elements [6, 5, 8] are all distinct, so we stop. Only one operation is needed.

Example 2:

Input: nums = [2,2]

Output: 1

Explanation:

After one operation, the array becomes empty, which meets the stopping condition.

Example 3:

Input: nums = [4,3,5,1,2]

Output: 0

Explanation:

All elements in the array are distinct, therefore no operations are needed.

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(minOperations(arr));
        
        sc.close();
    }
    public static int minOperations(int[] nums) {
        HashSet<Integer>set = new HashSet<>();

        int n = nums.length;
        int i=n-1;
        while(i>=0){
            if(set.contains(nums[i]))break;
            set.add(nums[i]);
            i--;
        }
        if(i<0)return 0;
        return (i+3)/3;
    }
}