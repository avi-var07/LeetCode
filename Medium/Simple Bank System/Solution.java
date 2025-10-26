/*You have been tasked with writing a program for a popular bank that will automate all its incoming transactions (transfer, deposit, and withdraw). The bank has n accounts numbered from 1 to n. The initial balance of each account is stored in a 0-indexed integer array balance, with the (i + 1)th account having an initial balance of balance[i].

Execute all the valid transactions. A transaction is valid if:

The given account number(s) are between 1 and n, and
The amount of money withdrawn or transferred from is less than or equal to the balance of the account.
Implement the Bank class:

Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered account2. Return true if the transaction was successful, false otherwise.
boolean deposit(int account, long money) Deposit money dollars into the account numbered account. Return true if the transaction was successful, false otherwise.
boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account. Return true if the transaction was successful, false otherwise.
 

Example 1:

Input
["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
Output
[null, true, true, true, false, false]

Explanation
Bank bank = new Bank([10, 100, 20, 50, 30]);
bank.withdraw(3, 10);    // return true, account 3 has a balance of $20, so it is valid to withdraw $10.
                         // Account 3 has $20 - $10 = $10.
bank.transfer(5, 1, 20); // return true, account 5 has a balance of $30, so it is valid to transfer $20.
                         // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
bank.deposit(5, 20);     // return true, it is valid to deposit $20 to account 5.
                         // Account 5 has $10 + $20 = $30.
bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
                         // so it is invalid to transfer $15 from it.
bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not exist.
 

Constraints:

n == balance.length
1 <= n, account, account1, account2 <= 105
0 <= balance[i], money <= 1012
At most 104 calls will be made to each function transfer, deposit, withdraw. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        long arr[] = new long[n];
        Bank bank = new Bank(arr);
        System.out.println("Enter "+n+" balances: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextLong();

        System.out.println("Enter number of operations: ");
        int op = sc.nextInt();

        String operations[] = new String[op];
        System.out.println("Enter all "+ op +" operations to perform one by one: ");
        boolean ans[] = new boolean[op];

        for(int i=0;i<op;i++){
            operations[i] = sc.next();
            if(operations[i].equalsIgnoreCase("transfer")){
                System.out.println("Enter account number to transfer from: ");
                int acc1  =sc.nextInt();
                System.out.println("Enter account number to transfer into: ");
                int acc2  =sc.nextInt();
                System.out.println("Enter money to transfer: ");
                long money = sc.nextLong();

                ans[i] = bank.transfer(acc1, acc2, money);
            }
            else if(operations[i].equalsIgnoreCase("deposit")){
                System.out.println("Enter account number: ");
                int account = sc.nextInt();
                System.out.println("Enter amount to deposit: ");
                long money = sc.nextLong();
                ans[i] = bank.deposit(account, money);
            }
            
            else if(operations[i].equalsIgnoreCase("withdraw")){
                System.out.println("Enter account number: ");
                int account = sc.nextInt();
                System.out.println("Enter amount to withdraw: ");
                long money = sc.nextLong();
                ans[i] = bank.withdraw(account, money);

            }
            else if(operations[i].equalsIgnoreCase("bank")){
                for(long ele: arr)System.out.print(ele+" ");
                System.out.println();
                
                ans[i] = true;
            }
        }
        for(var ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
}
class Bank {
    long balance[];
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<=balance.length&&account1>0&&account2<=balance.length&&account2>0&&money<=balance[account1-1]){
            balance[account1-1]-=money;
            balance[account2-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account>0&&account<=balance.length){
            balance[account-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>0&&account<=balance.length&&money<=balance[account-1]){
            balance[account-1]-=money;;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */