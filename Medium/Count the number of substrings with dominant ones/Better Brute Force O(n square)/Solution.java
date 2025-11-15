/*
You are given a binary string s.

Return the number of substrings with dominant ones.

A string has dominant ones if the number of ones in the string is greater than or equal to the square of the number of zeros in the string.

 

Example 1:

Input: s = "00011"

Output: 5

Explanation:

The substrings with dominant ones are shown in the table below.

i	j	s[i..j]	Number of Zeros	Number of Ones
3	3	1	0	1
4	4	1	0	1
2	3	01	1	1
3	4	11	0	2
2	4	011	1	2
Example 2:

Input: s = "101101"

Output: 16

Explanation:

The substrings with non-dominant ones are shown in the table below.

Since there are 21 substrings total and 5 of them have non-dominant ones, it follows that there are 16 substrings with dominant ones.

i	j	s[i..j]	Number of Zeros	Number of Ones
1	1	0	1	0
4	4	0	1	0
1	4	0110	2	2
0	4	10110	2	3
1	5	01101	2	3
 

Constraints:

1 <= s.length <= 4 * 104
s consists only of characters '0' and '1'. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(numberOfSubstrings(s));
        sc.close();
    }
    public static int numberOfSubstrings(String s) {
        int ans = 0;
        int n =s.length();
        int pref[] = new int[n];
        pref[0] = s.charAt(0)=='1'?1:0;
        for(int i=1;i<n;i++)pref[i] = pref[i-1]+(s.charAt(i)=='1'?1:0);
        for(int i=0;i<n;i++){
        
            for(int j=i;j<n;j++){
                int count1 = pref[j]-(i>0?pref[i-1]:0);
                int count0 = (j-i+1)-count1;
                int total0 = count0*count0;
                if(count1==total0)ans++;
                else if(total0>count1){
                    int move = total0-count1;
                    j+=move-1;
                }
                else{
                    ans++;
                    int k = (int)Math.sqrt(count1)-count0;
                    int nextj = j+k;
                    if(nextj>=n){
                        ans+=(n-j-1);
                        break;
                    }
                    else ans+=k;
                    j=nextj;
                }
        
            }
        }
        return ans;
    }
}