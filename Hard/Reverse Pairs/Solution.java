/*Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
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
        
        System.out.println("Number of Reverse Pairs are: "+reversePairs(arr));
        
        sc.close();
    }
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    static int mergeSort(int arr[], int low, int high){
        int mid = (low+high)/2;
        int count = 0;
        if(low>=high)return count;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+=countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;

    }
    static int countPairs(int arr[], int low, int mid, int high){
        int right = mid+1;
        int count = 0;
        for(int i = low;i<=mid;i++){
            while(right <= high && (long) arr[i] > 2L * arr[right])right++;

            count+=right-(mid+1);
        }
        return count;
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
        for(int i = low;i<=high;i++)
        arr[i]=temp.get(i-low);

    }
}