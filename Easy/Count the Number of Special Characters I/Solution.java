import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();

        System.out.println(numberOfSpecialChars(s));
        sc.close();
    }
    public static int numberOfSpecialChars(String word) {
        int cnt=0;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char ch: word.toCharArray()){
            if(ch>='a'&&ch<='z')freq1[ch-'a']++;
            else if(ch>='A'&&ch<='Z')freq2[ch-'A']++;
        }
        
        for(int i=0;i<26;i++)if(freq1[i]>0&&freq2[i]>0)cnt++;

        return cnt;
    }
}