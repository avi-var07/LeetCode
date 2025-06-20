/*In this appraoch, we check for: 
Bas loop chalao, aur har baar check karo:

Kya current == previous + 1 → toh sequence continue ho rahi hai

Kya current == previous → duplicate hai, skip karo

Else: sequence break ho gayi, count reset
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
        
        System.out.println("Longest Consecutive Sequence is: "+longestConsecutive(arr));
        sc.close();
    }
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int countCurrent = 0, longest = 0, lastSmaller = Integer.MIN_VALUE;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                countCurrent++;
                lastSmaller = nums[i];
            }
            else if(nums[i]!=lastSmaller){
                countCurrent = 1;
                lastSmaller  =nums[i];
            }

            if(countCurrent>longest)longest=countCurrent;
        }
        return longest;
    }
}