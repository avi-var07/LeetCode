/*Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        String a = sc.nextLine();
        System.out.println("Enter b: ");
        String b= sc.nextLine();

        System.out.println(addBinary(a, b));
        sc.close();
    }
    public static String addBinary(String a, String b) {
        // int x=Integer.valueOf(a,2);
        // int y=Integer.valueOf(b,2);

        // int sum=x+y;
        // return Integer.toBinaryString(sum);

        StringBuilder sb = new StringBuilder();
        int i=a.length()-1;
        int j =b.length()-1;

        int carry=0;

        while(i>=0||j>=0||carry==1){
            int currSum =carry; //carry humesha add hoga hi

            if(i>=0)currSum+=a.charAt(i--)-'0';
            if(j>=0)currSum+=b.charAt(j--)-'0';

            sb.append(currSum%2); //0+0=0, 0+1=1, 1+1=10 (2)
            carry=currSum/2; 
        }

        return sb.reverse().toString();
    }
}