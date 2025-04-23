import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        System.out.println("Number of groups that have the largest size when grouped according to the sum of its digits are: "+countLargestGroup(n));
        sc.close();
    }
    public static int sumOfDigits(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d;
            n/=10;
        }
        return sum;
    }
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for(int i=1;i<=n;i++){
            int sum = sumOfDigits(i);
            if(mp.containsKey(sum))mp.put(sum,mp.get(sum)+1);
            else mp.put(sum,1);
        }
        int maxi=-1;
        for(var ele: mp.entrySet())
        if(ele.getValue()>maxi)maxi=ele.getValue();

        int count=0;

        for(int value: mp.values())if(value==maxi)count++;

        return count;
    }
}