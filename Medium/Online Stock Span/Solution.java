/*Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();
        StockSpanner ss = new StockSpanner();
        int index = 0;
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            System.out.println("Enter query: ");
            String val = sc.next().toLowerCase();
            switch (val) {
                case "stockspanner":
                    ss = new StockSpanner();
                    arr[index++] = -1;
                    break;
                case "next":
                    System.out.println("Enter value: ");
                    int price = sc.nextInt();
                    arr[index++] = ss.next(price);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

        for(int ele: arr)System.out.print(ele+" ");
        sc.close();
    }
}
class StockSpanner {
    Stack<int[]>st;
    int ind;
    public StockSpanner() {
        st = new Stack<>();
        ind=-1;
    }
    
    public int next(int price) { 
        ind=ind+1;
        while(!st.isEmpty()&&st.peek()[0]<=price)st.pop();

        int ans  = ind-(st.isEmpty()?-1:st.peek()[1]);

        st.push(new int[]{price, ind});
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */