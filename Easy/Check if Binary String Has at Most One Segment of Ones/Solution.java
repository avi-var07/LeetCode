import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s =sc.nextLine();
        System.out.println(checkOnesSegment(s));
        sc.close();
    }
    //100 valid, 1001 invalid, 1 valid, 10 valid, 101 valid, 110011 invalid, 11001 invalid, 1100000000000000000001 invalid
    //mtlb agr 0 chl rha chlne do, 1 aaya to gaand hi faad do
    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}