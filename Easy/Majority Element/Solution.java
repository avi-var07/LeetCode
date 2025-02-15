/*
 169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

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