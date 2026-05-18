/*You are given a string s consisting of digits.

Return true if the absolute difference between every pair of adjacent digits is at most 2, otherwise return false.

The absolute difference between a and b is defined as abs(a - b).

 

Example 1:

Input: s = "132"

Output: true

Explanation:

The absolute difference between digits at s[0] and s[1] is abs(1 - 3) = 2.
The absolute difference between digits at s[1] and s[2] is abs(3 - 2) = 1.
Since both differences are at most 2, the answer is true.
Example 2:

Input: s = "129"

Output: false

Explanation:

The absolute difference between digits at s[0] and s[1] is abs(1 - 2) = 1.
The absolute difference between digits at s[1] and s[2] is abs(2 - 9) = 7, which is greater than 2.
Therefore, the answer is false.
 

Constraints:

2 <= s.length <= 100
s consists only of digits. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();

        System.out.println(isAdjacentDiffAtMostTwo(s));
        sc.close();
    }
    public static boolean isAdjacentDiffAtMostTwo(String s) {
        int n =s.length();
        for(int i=0;i<n-1;i++){
            int a= s.charAt(i)-'0';
            int b =s.charAt(i+1)-'0';

            if(Math.abs(a-b)>2)return false;
        }
        return true;
    }
}