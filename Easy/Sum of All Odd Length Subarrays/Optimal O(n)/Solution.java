import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Sum of odd length subarrays is: "+sumOddLengthSubarrays(arr));
        sc.close();
    }   
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int left = i+1;
            int right = arr.length-i;

            int totalSubarrays = left*right;

            int oddSubarrays = (totalSubarrays+1)/2;

            sum+=oddSubarrays*arr[i];
        }
        return sum;
    }

}