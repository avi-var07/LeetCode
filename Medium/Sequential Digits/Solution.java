/*An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter low: ");
        int low= sc.nextInt();
        
        System.out.println("Enter high: ");
        int high = sc.nextInt();

        List<Integer> ans= sequentialDigits(low, high);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<Integer> sequentialDigits(int low, int high) {
        //my approach:
        // List<Integer>ans=  new ArrayList<>();
        // Queue<Integer>queue= new LinkedList<>();

        // for(int i=1;i<=9;i++)queue.add(i);

        // while(!queue.isEmpty()){
        //     int curr =queue.poll();
        //     if(curr>=low&&curr<=high)ans.add(curr);

        //     int last =curr%10;
        //     if(last<9){
        //         int next=curr*10+(last+1);
        //         if(next<=high)queue.add(next);
        //     }
        // }
        // return ans;

        //better approach:

        List<Integer>ans=  new ArrayList<>();
        for(int len=1;len<=9;len++){
            for(int start=1;start<=10-len;start++){
                int num=0;
                int dig=start;

                for(int i=0;i<len;i++){
                    num=num*10+dig;
                    dig++;
                }

                if(num>=low&&num<=high)ans.add(num);
            }
        }
        return ans;
    }
}