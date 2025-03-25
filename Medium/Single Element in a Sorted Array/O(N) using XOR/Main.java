import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int ans = 0;
        for(int i=0;i<n;i++) ans^=arr[i];
        System.out.println("The element which occurs only once is: "+ans);
        sc.close();
    }
}