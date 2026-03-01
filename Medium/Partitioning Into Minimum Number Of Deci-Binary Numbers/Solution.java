/*A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

 

Example 1:

Input: n = "32"
Output: 3
Explanation: 10 + 11 + 11 = 32
Example 2:

Input: n = "82734"
Output: 8
Example 3:

Input: n = "27346209830709182346"
Output: 9
 

Constraints:

1 <= n.length <= 105
n consists of only digits.
n does not contain any leading zeros and represents a positive integer. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String s: ");
        String s = sc.nextLine();

        System.out.println(minPartitions(s));
        sc.close();
    }
    public static int minPartitions(String s) {
        //82734 hai agr to possible deci binary:
        //00000, 00001, 00011, 00111,01111 nhi ho skta kyuki leading zeroes not allowed
        //to mtlb humlog length se bada deci binary jaa nhi skte
        //possible ky ky hai 11111, 10001,10111 etc... ab humesha bada inmei se chunenge aur usse minus krenge taaki minimum operations mei kaam hojaye:
        //82734-11111 = 71623
        //71623-11111 = 60512
        //60512-11111=50401 (ismei carry wala nhi jayega 60512-11111 carry wgerah krk 49401 bn jata )
        //50401-11111 = 40300
        //40300-11111=30200
        //30200-11111=20100
        //20100-11111=10000
        //10000-10000=00000

        //total=8....


        //trick ye hai ki we can observe ki har iteration pe 1 reduce horha hai, to maximum digit k barabar operations lgenge
        int maxi=-1;
        for(char ch: s.toCharArray())if(ch-'0'>maxi)maxi=ch-'0';

        return maxi;
    }
}