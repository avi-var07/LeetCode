/*
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 */

import java.util.*;

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

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(visited[i]==true) continue;
            int count=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    visited[j]=true;
                    count++;
                }
            }
            if(count>n/3) list.add(arr[i]);
        }
        System.out.println("The elements which are repeated more than n/3 times are: "+list);
        sc.close();
    }
}