/*Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103 */
import java.util.*;
class Solution {
    public static int binary(int n, int arr[], int exclude){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==n){
                if (mid != exclude) return mid;
                else if (arr[mid] < n)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else if(arr[mid]<n)
            low = mid+1;
            else
            high=mid-1;
        } 
        return -1;
    }
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int key = arr[i]*2;
            int found=binary(key,arr,i);
            if(found!=-1)
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(checkIfExist(arr));
        sc.close();
    }
}