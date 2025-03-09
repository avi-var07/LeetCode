import java.util.*;
class Solution {
    static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
        return -1;
        int nl=needle.length();
        for(int i=0;i<=haystack.length()-nl;i++){
            String str = haystack.substring(i,i+nl);
            if(str.equals(needle))
            return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the haystack String: ");
        String haystack = sc.next();
        System.out.println("Enter the needle String: ");
        String needle = sc.next();
        System.out.println(strStr(haystack,needle));
        sc.close();
    }
}