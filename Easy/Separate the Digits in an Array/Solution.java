/*Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

To separate the digits of an integer is to get all the digits it has in the same order.

For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].


Example 1:

Input: nums = [13,25,83,77]
Output: [1,3,2,5,8,3,7,7]
Explanation:
- The separation of 13 is [1,3].
- The separation of 25 is [2,5].
- The separation of 83 is [8,3].
- The separation of 77 is [7,7].
answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
Example 2:

Input: nums = [7,1,3,9]
Output: [7,1,3,9]
Explanation: The separation of each integer in nums is itself.
answer = [7,1,3,9].


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 105

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

        int ans[] = separateDigits(arr);
        for(int ele: ans)System.out.print(ele+' ');
        sc.close();
    }
    public static int[] separateDigits(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        for(int ele: nums){
            Stack<Integer>st = new Stack<>();
            while(ele!=0){
                st.push(ele%10);
                ele/=10;
            }
            while(!st.isEmpty())ans.add(st.pop());
        }
        int size= ans.size();
        int answer[] = new int[size];
        int index=0;
        for(int ele: ans)answer[index++]=ele;

        return answer;
    }
}