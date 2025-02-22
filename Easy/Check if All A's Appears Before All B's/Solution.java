import java.util.Scanner;

class Solution {
    static boolean checkString(String s) {
        int n = s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='b'){
                if(s.charAt(i)>s.charAt(i+1))
                return false;
            }
            else
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");

        String s = sc.nextLine();
        

        System.out.println(checkString(s));
        sc.close();
    }
}