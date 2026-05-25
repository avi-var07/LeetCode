/*You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

 

Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 

Constraints:

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
It is guaranteed that A and B are both a permutation of n integers. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter "+n+" elements of arr1: ");
        for(int i=0;i<n;i++) arr1[i] = sc.nextInt();
        
        int arr2[] = new int[n];
        System.out.println("Enter "+n+" elements of arr2: ");
        for(int i=0;i<n;i++) arr2[i] = sc.nextInt();

        int ans[] = findThePrefixCommonArray(arr1, arr2);

        for(int ele: ans)System.out.println(ele+" ");
        
        sc.close(); 
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n =A.length;
        int ans[] = new int[n];
        // Set<Integer>setA = new HashSet<>();
        // Set<Integer>setB = new HashSet<>();

        // for(int i=0;i<n;i++){
        //     setA.add(A[i]);
        //     setB.add(B[i]);
            
        //     int count=0;
        //     for(int ele: setA)if(setB.contains(ele))count++;

        //     ans[i]=count;
        // }

        int freq[] = new int[n+1];
        int cnt=0;

        for(int i=0;i<n;i++){
            freq[A[i]]++;

            if(freq[A[i]]==2)cnt++;

            freq[B[i]]++;
            if(freq[B[i]]==2)cnt++;


            ans[i]=cnt;
        }
        return ans;

    }
}