import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target for two sum: ");
        int target = sc.nextInt();
        int result[]=twoSum(arr, target);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}