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
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i])st.pop();

            pse[i] = st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])st.pop();

            nse[i] = st.isEmpty()?n:st.peek();

            st.push(i);
        }
        
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;

            int area = heights[i]*(left+right-1);
            if(area>maxi)maxi=area;
        }
        return maxi;
    }
}