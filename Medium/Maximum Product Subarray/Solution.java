import java.util.*;
class Solution{
    public static int maxProduct(int []nums){
        int n=nums.length;
        int maxProduct=Integer.MIN_VALUE;
        int prefix=1,suffix=1;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-i-1];
            maxProduct=Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = maxProduct(nums);
        System.out.println("The maximum product of a contiguous subarray is: " + result);
        sc.close();
    }
}