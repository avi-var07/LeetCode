import java.util.Scanner;
class Solution {
    public static boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]) count++;
        }
        return count<=1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        if(check(nums)) System.out.println("The array is sorted and rotated.");
        else System.out.println("The array is not sorted and rotated.");
        sc.close();
    
        
    }
}