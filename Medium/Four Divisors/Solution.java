/*Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

 

Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation: 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
Example 2:

Input: nums = [21,21]
Output: 64
Example 3:

Input: nums = [1,2,3,4,5]
Output: 0
 

Constraints:

1 <= nums.length <= 104
1 <= nums[i] <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(sumFourDivisors(arr));
        sc.close();
    }
    public static int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int ele: nums)sum+=count(ele);

        return sum;
        
    }
    static int count(int ele){
        int count =0, sum=0;
        for(int i=1;i*i<=ele;i++){
            if(ele%i==0){
                if(i==ele/i){
                    count+=1;
                    sum+=i;
                }
                else{
                    count+=2;
                    sum+=i+(ele/i);
                }
            }
            if(count>4)return 0;
        }
        if(count==4)return sum;

        return 0;
    }
}