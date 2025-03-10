/*Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106 */
import java.util.*;
import java.util.Arrays;

class Solution {
    static int countPrimes(int n) {
        // Agar n 2 se chhota hai toh seedha return 0, koi prime nahi hoga 
        if (n <= 2) return 0;  

        // Ek array banaya jisme initially sabko prime maana h (true rakha)
        boolean[] isPrime = new boolean[n];  
        Arrays.fill(isPrime, true);  
        
        // 0 aur 1 toh prime hote hi nahi, toh unko false mark kar diya 
        isPrime[0] = isPrime[1] = false;  

        // Ab sirf sqrt(n) tak check karna padega, full loop chala toh TLE 
        for (int i = 2; i * i < n; i++) {  
            if (isPrime[i]) {  // Agar i prime hai toh uske multiples ko hata dena h 
                for (int j = i * i; j < n; j += i) {  // i*i se start, pehle wale toh already mark ho chuke honge
                    isPrime[j] = false;  // Multiple prime nahi, toh false mark kar diya 
                }  
            }  
        }

        int count = 0;  
        for (boolean prime : isPrime) {  
            if (prime) count++;  
        }

    
        return count;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println(countPrimes(n));
        sc.close();
    }
}