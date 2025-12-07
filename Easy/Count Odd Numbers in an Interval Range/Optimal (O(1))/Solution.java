import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter low: ");
        int low = sc.nextInt();
        System.out.println("Enter high: ");
        int high = sc.nextInt();
        System.out.println(countOdds(low, high));

        sc.close();
    }
    public static int countOdds(int low, int high) {
        if(low%2==0&&high%2==0)return (high-low)/2;
        return ((high-low)/2)+1;
    }
    
}