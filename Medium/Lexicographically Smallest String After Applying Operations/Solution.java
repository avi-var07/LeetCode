/*You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.

You can apply either of the following two operations any number of times and in any order on s:

Add a to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456" and a = 5, s becomes "3951".
Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".
Return the lexicographically smallest string you can obtain by applying the above operations any number of times on s.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "0158" is lexicographically smaller than "0190" because the first position they differ is at the third letter, and '5' comes before '9'.

 

Example 1:

Input: s = "5525", a = 9, b = 2
Output: "2050"
Explanation: We can apply the following operations:
Start:  "5525"
Rotate: "2555"
Add:    "2454"
Add:    "2353"
Rotate: "5323"
Add:    "5222"
Add:    "5121"
Rotate: "2151"
Add:    "2050"​​​​​
There is no way to obtain a string that is lexicographically smaller than "2050".
Example 2:

Input: s = "74", a = 5, b = 1
Output: "24"
Explanation: We can apply the following operations:
Start:  "74"
Rotate: "47"
​​​​​​​Add:    "42"
​​​​​​​Rotate: "24"​​​​​​​​​​​​
There is no way to obtain a string that is lexicographically smaller than "24".
Example 3:

Input: s = "0011", a = 4, b = 2
Output: "0011"
Explanation: There are no sequence of operations that will give us a lexicographically smaller string than "0011".
 

Constraints:

2 <= s.length <= 100
s.length is even.
s consists of digits from 0 to 9 only.
1 <= a <= 9
1 <= b <= s.length - 1 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s =sc.nextLine();
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println(findLexSmallestString(s,a,b));
        sc.close();
    }
    public static String findLexSmallestString(String s, int a, int b) {
        int n =s.length();
        Set<String>vis = new HashSet<>();
        Queue<String>queue = new LinkedList<>();
        queue.add(s);
        vis.add(s);

        String res= s;
        //List<String>ans = new ArrayList<>(); brute force ki trh queue mei niklne k baad add krdo saare possible fir sort krk smallest return
        //better hai queue se nikalne k baad hi compare krk res update krdo
        while(!queue.isEmpty()){
            String curr = queue.poll();
            //ans.add(curr);
            if(curr.compareTo(res)<0)res=curr;

            String op1 = inc(curr, a, n);
            String op2 = rot(curr, b, n);

            if(!vis.contains(op1)){
                queue.add(op1);
                vis.add(op1);
            }
            if(!vis.contains(op2)){
                queue.add(op2);
                vis.add(op2);
            }
        }
        // Collections.sort(ans);
        // return ans.get(0);
        return res;
    }
    static String inc(String s, int a, int n){
        char curr[] = s.toCharArray();
        for(int i=0;i<n;i++){
            if(i%2==1){
                int digit = curr[i]-'0';
                digit=(digit+a)%10;
                curr[i]=(char)(digit+'0');
            }
        }
        return new String(curr);
    }

    //brute version to rotate:
    // static String rot(String s, int b, int n){
    //     char curr[] = s.toCharArray();
    //     reverse(curr,0,n-1);
    //     reverse(curr,0,b-1);
    //     reverse(curr,b,n-1);
        
    //     return new String(curr);
    // }
    // static void reverse(char arr[], int a, int b){
    //     while(a<b){
    //         char temp =arr[a];
    //         arr[a]=arr[b];
    //         arr[b]=temp;
    //         a++;
    //         b--;
    //     }
    // }

    //better version to rotate:

    static String rot(String s, int b, int n){
        b%=n;
        return s.substring(n-b)+s.substring(0, n-b);

        // return s.substring(b)+s.substring(0, b); ye for left rotate hai
    }
}