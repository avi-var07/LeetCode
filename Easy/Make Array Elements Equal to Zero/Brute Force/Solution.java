/*You are given an integer array nums.

Start by selecting a starting position curr such that nums[curr] == 0, and choose a movement direction of either left or right.

After that, you repeat the following process:

If curr is out of the range [0, n - 1], this process ends.
If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right, or decrementing curr if you are moving left.
Else if nums[curr] > 0:
Decrement nums[curr] by 1.
Reverse your movement direction (left becomes right and vice versa).
Take a step in your new direction.
A selection of the initial position curr and movement direction is considered valid if every element in nums becomes 0 by the end of the process.

Return the number of possible valid selections.

 

Example 1:

Input: nums = [1,0,2,0,3]

Output: 2

Explanation:

The only possible valid selections are the following:

Choose curr = 3, and a movement direction to the left.
[1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,0].
Choose curr = 3, and a movement direction to the right.
[1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].
Example 2:

Input: nums = [2,3,4,0,4,1,0]

Output: 0

Explanation:

There are no possible valid selections.

 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
There is at least one element i where nums[i] == 0. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Total Valid Sections are: "+countValidSelections(arr));
        sc.close();
    }
    public static int countValidSelections(int[] nums) {
        int  n = nums.length, ans=0;
    
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int left[] = nums.clone();
                if(check(left, i, -1))ans++;
                int right[] = nums.clone();
                if(check(right, i, 1))ans++;
            }
        }
        return ans;
    }
    static boolean check(int arr[], int index, int dir){
        while(index>=0&&index<arr.length){
            if(arr[index]==0)index+=dir;
            else{
                arr[index]--;
                dir*=-1;
                index+=dir;
            }
          
        }
        for(int ele: arr)if(ele!=0)return false;

        return true;
    }
}