import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements of array (0 to n): ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Missing number is: "+missingNumber(arr));
        sc.close();
    }
    public static int missingNumber(int arr[]){
        int i=0, n=arr.length;
        while(i<n){
            int correct = arr[i];
            if(arr[i]==n)i++;
            else if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
            else i++;
        }
        int ans=-1;
        for(int j=0;j<n;j++) if(arr[j]!=j)ans=j;

        if(ans==-1)return n;
        return ans;
    }
}