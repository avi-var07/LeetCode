import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static boolean check(int[] nums) {
        int n = nums.length;
        int ans[] = Arrays.copyOf(nums, n);

        Arrays.sort(ans);

        if(Arrays.equals(ans,nums))
        return true;

        else{
            int r=1;
            while(r<=n){
                int last = nums[n-1];
                for(int i=n-1;i>0;i--)
                nums[i]=nums[i-1];

                nums[0] = last;

                if(Arrays.equals(nums,ans))
                return true;

                else
                r++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println(check(arr));
        sc.close();
    }
}