/*There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

 

Example 1:

Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 

Constraints:

1 <= startValue, target <= 109 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter startValue: ");
        int s = sc.nextInt();
        
        System.out.println("Enter targetValue: ");
        int t = sc.nextInt();

        System.out.println(brokenCalc(s, t));
        sc.close();
    }
    public static int brokenCalc(int startValue, int target) {
        int ans=0;
        //wrong approach: 
        // if(startValue==target)return ans;

        // while(startValue<target){
        //     startValue*=2;
        //     ans++;
        //     if(startValue==target)return ans;
        // }
        // while(startValue>target){
        //     startValue-=1;
        //     ans++;
        //     if(startValue==target)return ans;
        // }

        //its easier to reduce, rather than moving forward:

        //if(target even) then /2, else -1; (kyuki multiply k baad humesha even banta tha, to even pe hi /2 kr skte)

        while(target>startValue){
            if(target%2==0)target/=2;
            else target+=1;

            ans++;
        }

        //ab targetValue<=startValue hai, mtlb ab divide krenge to aur chota hojayega ...infi
        //to ab ky bacha? sirf +1 operation (forward hi jaana pdega ab: )
        return ans+(startValue-target);
    }
}