import java.util.*;
class Solution {
    public static int singleNumber(int[] arr) {
        int ones = 0, twos = 0;

        for (int num : arr) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
         return ones;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = singleNumber(arr);
        System.out.println("The element that appears only once is: " + result);
        sc.close();
    }
}
