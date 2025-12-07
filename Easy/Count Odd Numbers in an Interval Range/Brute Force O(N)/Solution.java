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
        int ans = 0;
        for(int i=low;i<=high;){
            if(i%2==1){
                ans++;
                i+=2;
            }
            else i++;
        }
        return ans;
    }
    
}