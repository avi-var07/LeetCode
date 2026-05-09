/* */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();

        System.out.println(minFlips(s));
        sc.close();
    }
    public static int minFlips(String s) {
        int n =s.length();

        int ones=0;
        int zeroes=0;

        for(char ch: s.toCharArray()){
            if(ch=='0')zeroes++;
            else ones++;
        }

        int ans = Integer.MAX_VALUE;

        ans=Math.min(ans, ones);
        ans=Math.min(ans, zeroes);

        if(ones>=1)ans=Math.min(ans, ones-1);

        if(n>=2){
            int cost=0;

            if(s.charAt(0)=='0')cost++;
            if(s.charAt(n-1)=='0')cost++;

            for(int i=1;i<n-1;i++)if(s.charAt(i)=='1')cost++;

            ans=Math.min(ans, cost);
        }
         return ans;   
    }
}