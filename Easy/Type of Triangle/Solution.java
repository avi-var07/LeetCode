/*You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.

 

Example 1:

Input: nums = [3,3,3]
Output: "equilateral"
Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.
Example 2:

Input: nums = [3,4,5]
Output: "scalene"
Explanation: 
nums[0] + nums[1] = 3 + 4 = 7, which is greater than nums[2] = 5.
nums[0] + nums[2] = 3 + 5 = 8, which is greater than nums[1] = 4.
nums[1] + nums[2] = 4 + 5 = 9, which is greater than nums[0] = 3. 
Since the sum of the two sides is greater than the third side for all three cases, therefore, it can form a triangle.
As all the sides are of different lengths, it will form a scalene triangle. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the triangles length one by one: ");
        int arr[]=new int[3];
        for(int i=0;i<3;i++)arr[i]=sc.nextInt();
        String result = triangleType(arr);

        System.out.println(result);

        sc.close();
    }
    public static String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return "equilateral";
        else if ((nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
                 && nums[0] + nums[1] > nums[2]
                 && nums[1] + nums[2] > nums[0]
                 && nums[0] + nums[2] > nums[1])
            return "isosceles";
        else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]
                 && nums[0] + nums[1] > nums[2]
                 && nums[1] + nums[2] > nums[0]
                 && nums[0] + nums[2] > nums[1])
            return "scalene";
        return "none";
    }
}