/*
 To Sort an array having only 0,1 or 2, we follow the Dutch National Flag Algorithm to solve in O(n) which is a three pointer approach.

 We consider a hypothetical array in which the low pointer and mid pointer initially is set at the 0 position and high pointer at n-1 position. 

 0 to low-1 will have 0's, low to mid-1 will have 1's, mid to high-1 will have 0, 1 or 2, high to n-1 will have 2's. We sort in mid to high-1 only because on extreme left it will be sorted so as on extreme right.


 Three Conditions: a[mid]==0 or a[mid]==1 or a[mid]==2;

 if a[mid]==0, then simply swap(a[low], a[mid]) and move left and mid pointer by 1.
 if(a[mid]==1) then already sorted till here just move mid pointer by 1;
 else if a[mid]==2 then swap a[high] with a[mid] and decrease the high pointer by 1 as we are moving the 2 to first position of sorted extreme right, basically shrinking the mid to high range.


 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements (0, 1 or 2): ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i]!=0 && arr[i]!=1 && arr[i]!=2){
                System.out.println("You Should enter only 0, 1 or 2!!!");
                System.exit(0);
            }
        }

        sortColors(arr);

        for(int num: arr)
        System.out.print(num+" ");

        sc.close();
    }
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high  = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1)mid++;

            else {
                swap(nums, high, mid);
                high--;
            }
        }

    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}