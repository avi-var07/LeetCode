/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1
  */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = sc.nextInt();
        System.out.println("Enter y: ");
        int y= sc.nextInt();
        System.out.println("Hamming Distance is: "+hammingDistance(x, y));
        sc.close();
    }
    public static int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        while(res!=0){
            res=res&(res-1);
            count++;
        }
        return count;
    }
}