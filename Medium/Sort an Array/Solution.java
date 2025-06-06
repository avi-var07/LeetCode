/*Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entet number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Entet the elements: ");

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sortArray(arr);

        for(int ele: arr)
        System.out.print(ele+" ");
        sc.close();
    }
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);

        return nums;
    }
    static void mergeSort(int arr[], int low, int high){

        if(low>=high)return;

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);

    }

    static void merge(int arr[], int low, int mid, int high){
        int left = low;
        int right = mid+1;

        ArrayList<Integer> temp = new ArrayList<>();

        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++)
        arr[i]=temp.get(i-low);


    }
}