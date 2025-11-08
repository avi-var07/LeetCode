import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        long n = sc.nextLong();

        System.out.println(removeZeros(n));
        sc.close();
    }
    public static long removeZeros(long n) {
        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(n);
        for(char ch: num.toCharArray()){
            if(ch=='0')continue;
            sb.append(ch);
        }
        
        return Long.parseLong(sb.toString());
    }
}