import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row number of the pascal's triangle to print: ");
        int n = sc.nextInt();
        List<Integer> ans = getRow(n);

        for(int ele: ans)
        System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long ele = 1;
        rowIndex+=1;
        for(int i = 1;i<rowIndex;i++){
            ele = ele*(rowIndex-i);
            ele = ele/i;
            ans.add((int)ele);

        }

        return ans;
    }
    

}