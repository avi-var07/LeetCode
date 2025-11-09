/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        System.out.println(trap(arr));
        sc.close();
    }
    public static int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int lMax = 0, rMax = 0;
        int l = 0, r = n-1;
        while(l<r){
            if(height[l]>lMax)lMax = height[l];
            if(height[r]>rMax)rMax = height[r];
            if(lMax<=rMax){
                total+=lMax-height[l];
                l++;
            }
            else{
                total+=rMax-height[r];
                r--;
            }
        }
        return total;

    }
}