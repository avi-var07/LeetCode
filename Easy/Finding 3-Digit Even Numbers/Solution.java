/*You are given an integer array digits, where each element is a digit. The array may contain duplicates.

You need to find all the unique integers that follow the given requirements:

The integer consists of the concatenation of three elements from digits in any arbitrary order.
The integer does not have leading zeros.
The integer is even.
For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

Return a sorted array of the unique integers.

 

Example 1:

Input: digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
Explanation: All the possible integers that follow the requirements are in the output array. 
Notice that there are no odd integers or integers with leading zeros.
Example 2:

Input: digits = [2,2,8,8,2]
Output: [222,228,282,288,822,828,882]
Explanation: The same digit can be used as many times as it appears in digits. 
In this example, the digit 8 is used twice each time in 288, 828, and 882. 
Example 3:

Input: digits = [3,7,5]
Output: []
Explanation: No even integers can be formed using the given digits.
 

Constraints:

3 <= digits.length <= 100
0 <= digits[i] <= 9
 */
import java.util.*;
class Solution {
    public static void findEvenNumbers(int[] digits) {
        Set<Integer>set = new TreeSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i]==0)continue;
            for(int j=0;j<digits.length;j++){
                if(i==j)continue;
                for(int k=0;k<digits.length;k++){
                    if(k==i||k==j)continue;

                    int num = digits[i]*100+digits[j]*10+digits[k];
                    if(num%2==0)set.add(num);
                }
            }
        }

        int arr[]=new int[set.size()];
        int i=0;
        for(int ele:set)
        arr[i++]=ele;    

        for(int ele:arr)
        System.out.print(ele+" ");
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();
        System.out.println("Enter the digits to form with: ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("3-digit even numbers are: "+findEvenNumbers(arr));
        sc.close();

    
    }
}