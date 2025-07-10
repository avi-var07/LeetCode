import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows to print (Pascal Triangle): ");
        int n = sc.nextInt();
        
        List<List<Integer>> result = generate(n);

        for(List<Integer> ele: result)
        System.out.print(ele+" "); 
        sc.close();
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        result.add(generateRow(i));

        return result;
    }
    static List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int col=1;col<row;col++){
            ans = ans*(row-col);
            ans = ans/col;
            list.add((int)(ans));
        }
        return list;
    }
}
