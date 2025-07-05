/*Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

 

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
 

Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500 */

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
        
        System.out.println("Lucky Integer in the array is, i.e, the largest integer whose frequency is same as to the element in the array is: "+findLucky(arr));
        sc.close();
    }

    public static int findLucky(int[] arr) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele: arr)
        map.put(ele, map.getOrDefault(ele,0)+1);

        for(var ele: map.entrySet()){
            if(ele.getValue()==ele.getKey()){
                if(ele.getKey()>ans)
                ans=ele.getKey();
            }
        }

        return ans;
    }
}