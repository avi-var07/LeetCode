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
    static int sumOddLengthSubarrays(int arr[]){
        int total=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                int len = j-i+1;
                if(len%2!=0)total+=sum;
                
            }
        }
        return total;
    }
}