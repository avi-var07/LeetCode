/*You are given a string s consisting of lowercase English letters and digits.

For each character, its mirror character is defined by reversing the order of its character set:

For letters, the mirror of a character is the letter at the same position from the end of the alphabet.
For example, the mirror of 'a' is 'z', and the mirror of 'b' is 'y', and so on.
For digits, the mirror of a character is the digit at the same position from the end of the range '0' to '9'.
For example, the mirror of '0' is '9', and the mirror of '1' is '8', and so on.
For each unique character c in the string:

Let m be its mirror character.
Let freq(x) denote the number of times character x appears in the string.
Compute the absolute difference between their frequencies, defined as: |freq(c) - freq(m)|
The mirror pairs (c, m) and (m, c) are the same and must be counted only once.

Return an integer denoting the total sum of these values over all such distinct mirror pairs.

 

Example 1:

Input: s = "ab1z9"

Output: 3

Explanation:

For every mirror pair:

c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
a	z	1	1	0
b	y	1	0	1
1	8	1	0	1
9	0	1	0	1
Thus, the answer is 0 + 1 + 1 + 1 = 3.

Example 2:

Input: s = "4m7n"

Output: 2

Explanation:

c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
4	5	1	0	1
m	n	1	1	0
7	2	1	0	1
Thus, the answer is 1 + 0 + 1 = 2.

Example 3:

Input: s = "byby"

Output: 0

Explanation:

c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
b	y	2	2	0
Thus, the answer is 0.

 

Constraints:

1 <= s.length <= 5 * 105
s consists only of lowercase English letters and digits. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        System.out.println(mirrorFrequency(s));
        sc.close();
    }
    public static int mirrorFrequency(String s) {
        //Map<Character, Character>map = new HashMap<>();
        // map.put('a','z');
        // map.put('b','y');
        // map.put('c','x');
        // map.put('d','w');
        // map.put('e','v');
        // map.put('f','u');
        // map.put('g','t');
        // map.put('h','s');
        // map.put('i','r');
        // map.put('j','q');
        // map.put('k','p');
        // map.put('l','o');
        // map.put('m','n');
        // map.put('n','m');
        // map.put('o','l');
        // map.put('p','k');
        // map.put('q','j');
        // map.put('r','i');
        // map.put('s','h');
        // map.put('t','g');
        // map.put('u','f');
        // map.put('v','e');
        // map.put('w','d');
        // map.put('x','c');
        // map.put('y','b');
        // map.put('z','a');
        // map.put('0','9');
        // map.put('1','8');
        // map.put('2','7');
        // map.put('3','6');
        // map.put('4','5');
        // map.put('5','4');
        // map.put('6','3');
        // map.put('7','2');
        // map.put('8','1');
        // map.put('9','0');

        //Better way to write the about lines: 
        // for(int i=0;i<26;i++)map.put((char)('a'+i),(char)('z'-i));
        
        // for(int i=0;i<10;i++)map.put((char)('0'+i), (char)('9'-i));

        // int n =s.length();
        // int freq[] = new int[36];
        // for(char ch: s.toCharArray()){
        //     if(Character.isDigit(ch))freq[26+(ch-'0')]++;
        //     else freq[ch-'a']++;
        // }

        //int sum =0;
        //Set<List<Character>>set=new HashSet<>();
        // Set<String>set = new HashSet<>();
        // for(char c: s.toCharArray()){
        //     char m = map.get(c);
        //ye pair banakr set mei as a pair store kro ya fir set banao string ka fir add kro
            // List<Character>pair1= new ArrayList<>();
            // List<Character>pair2= new ArrayList<>();
            // pair1.add(c);
            // pair1.add(m);
            // pair2.add(m);
            // pair2.add(c);
            // String s1=""+c+m;
            // String s2=""+m+c;
            // if(!set.contains(s1)&&!set.contains(s2)){
            //     int f1=0, f2=0;
            //     if(Character.isDigit(c))f1=freq[26+(c-'0')];
            //     else f1=freq[c-'a'];
            //     if(Character.isDigit(m))f2=freq[26+(m-'0')];
            //     else f2=freq[m-'a'];
            //     sum+=Math.abs(f1-f2);
            // }
            // set.add(s1);
            // set.add(s2);
        //}

        //Optimised Approach:

        //Set ki zarurat hi nahi hai
        // Kyunki mirror pairs fixed hote hain.
        // Total pairs:

        // Letters → 13 pairs (a-z, b-y, ..., m-n)
        // Digits → 5 pairs (0-9, 1-8, ..., 4-5)

        // Toh hum direct pairs pe loop chala sakte hain.

        int freq[]= new int[36];

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch))freq[26+(ch-'0')]++;
            else freq[ch-'a']++;
        }

        int sum=0;
        //letters...26 hote ...mirror mei 13 hojayenge
        for(int i=0;i<13;i++){
            int f1=freq[i];
            int f2=freq[25-i]; //mirror character
            sum+=Math.abs(f1-f2); //jo characters nhi bhi honge present word mei wo 0 honge, to add hojayenge ki frak penda hai
        }
        //digits:

        for(int i=0;i<5;i++){
            int f1=freq[26+i];
            int f2=freq[26+(9-i)];
            sum+=Math.abs(f1-f2);
        }
        return sum;
    }
}