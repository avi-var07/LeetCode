/*Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.

 

Example 1:

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
Example 2:

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.
 

Constraints:

3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println("Enter c: ");
        int c = sc.nextInt();

        System.out.println("Total Good Triplets are: "+countGoodTriplets(arr, a, b, c));        
        sc.close();
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count =0;
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j])>a)continue;
                
                for(int k = j+1;k<arr.length;k++){
                    if(Math.abs(arr[j]-arr[k])>b)continue;
                    if(Math.abs(arr[i]-arr[k])>c)continue;

                    count++;
                }
            }
        }
        return count;
    }
}