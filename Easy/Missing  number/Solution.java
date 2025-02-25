import java.util.*;
class Solution {
    static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0,c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                c++;
                ans=i;
                break;
            }
        }
        if(c==0)
        return nums.length;
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();
        System.out.println("The missing number is "+missingNumber(nums));
        sc.close();
    }
}