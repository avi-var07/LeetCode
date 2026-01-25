import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println(minimumDifference(arr, k));
        sc.close();
    }
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        
        int i=0, j=k-1, n=nums.length;
        int ans= Integer.MAX_VALUE;
        while(j<n){
            ans=Math.min(nums[j]-nums[i], ans);
            i++;
            j++;
        }
        return ans;
    }
}