import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of array :");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Number of elements with even number digits: "+findNumbers(arr));
        sc.close();
    }
    public static int findNumbers(int[] nums) {
        int count=0;
        for(int ele:nums)
        if(((int)(Math.log10(ele))+1)%2==0)count++;
        return count;
    }
}