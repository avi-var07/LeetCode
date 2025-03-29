import java.util.*;
class Solution {
    public static int dominantIndex(int[] nums) {
        int maxi = -1, index=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxi) {
                maxi=nums[i];
                index = i;
            }
                
        }
        for(int num:nums){
            if(num!=maxi){
                if((2*num)>maxi)
                return -1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(dominantIndex(nums));
        sc.close();
    }
}