/*You are given an integer array nums.

An array is considered alternating prime if:

Elements at even indices (0-based) are prime numbers.
Elements at odd indices are non-prime numbers.
In one operation, you may increment any element by 1.

Return the minimum number of operations required to transform nums into an alternating prime array.

A prime number is a natural number greater than 1 with only two factors, 1 and itself.

 

Example 1:

Input: nums = [1,2,3,4]

Output: 3

Explanation:

The element at index 0 must be prime. Increment nums[0] = 1 to 2, using 1 operation.
The element at index 1 must be non-prime. Increment nums[1] = 2 to 4, using 2 operations.
The element at index 2 is already prime.
The element at index 3 is already non-prime.
Total operations = 1 + 2 = 3.

Example 2:

Input: nums = [5,6,7,8]

Output: 0

Explanation:

The elements at indices 0 and 2 are already prime.
The elements at indices 1 and 3 are already non-prime.
No operations are needed.

Example 3:

Input: nums = [4,4]

Output: 1

Explanation:

The element at index 0 must be prime. Increment nums[0] = 4 to 5, using 1 operation.
The element at index 1 is already non-prime.
Total operations = 1.

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(minOperations(arr));
        sc.close();
    }
    public static int minOperations(int[] nums) {
        int ans=0;
        int n =nums.length;
        //approach 1
        // for(int i=0;i<n;i++){
        //     int steps=0;
        //     if(i%2==0){
        //         while(!isPrime(nums[i])){
        //             nums[i]++;
        //             steps++;
        //         }
        //     }
        //     else{
        //         while(isPrime(nums[i])){
        //             nums[i]++;
        //             steps++;
        //         }
        //     }
        //     ans+=steps;
        // }

        //approach 2: using sieve and calculation nextPrime and nextNonPrime

        int maxPossible = 110000;

        boolean isPrime[] = sieve(maxPossible);

        int nextPrime[] = new int[maxPossible+1];
        int nextNon[] = new int[maxPossible+1];

        int nextP = -1, nextNP=-1;

        for(int i=maxPossible;i>=0;i--){

            if(isPrime[i])nextP=i;
            else nextNP=i;

            nextPrime[i]=nextP;
            nextNon[i]=nextNP;
        }

        for(int i=0;i<n;i++){
            int ele=nums[i];
            if(i%2==0)ans+=nextPrime[ele]-ele;
            else ans+=nextNon[ele]-ele;
        }
        return ans;
    }
    // static boolean isPrime(int n){
    //     if(n<=1)return false;
    //     for(int i=2;i*i<=n;i++)if(n%i==0)return false;
    //     return true;
    // }

    static boolean[] sieve(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i)isPrime[j]=false;
            }
        }
        return isPrime;
    }
}