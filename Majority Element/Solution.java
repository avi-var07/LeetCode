import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
        
        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]==true) continue;
            int count=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    visited[j]=true;
                    count++;
                }
            }
            if(count>n/2)
            System.out.println(arr[i]);
        }
        sc.close();
    }
}