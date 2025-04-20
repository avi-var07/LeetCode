import java.util.*;
class Solution {
    public static int findDuplicate(int[] nums) {
        int i=0, n=nums.length;
        while(i<n){
            int corrected = nums[i]-1;
            if(nums[i]!=nums[corrected]){
                int temp=nums[i];
                nums[i]=nums[corrected];
                nums[corrected]=temp;
            }
            else i++;
        }
        for(int j=0;j<n;j++) if(nums[j]!=j+1) return nums[j];

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = findDuplicate(nums);
        System.out.println("The duplicate number is: " + result);
        sc.close();
    }
}