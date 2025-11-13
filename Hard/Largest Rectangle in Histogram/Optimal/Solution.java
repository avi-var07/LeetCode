/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(largestRectangleArea(arr));
        sc.close();
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>st = new Stack<>();
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
                int eleInd = st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxi = Math.max(maxi, heights[eleInd]*(nse-pse-1));

            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int eleInd = st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxi = Math.max(maxi, heights[eleInd]*(nse-pse-1));
        }
        return maxi;
    }
}