import java.util.*;
class Solution {
    public static int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        ans^=nums[i];

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array (odd only):");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (every element should be twice except one):");
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();
        System.out.println("The only element that is present only once is: "+singleNumber(nums));
        sc.close();
    }
}