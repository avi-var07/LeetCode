/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        List<int[]> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.print("Enter start: ");
            int start = sc.nextInt();
            System.out.print("Enter end: ");
            int end = sc.nextInt();
            arr.add(new int[]{start, end});
        }

        int ans[][] = merge(arr.toArray(new int[arr.size()][])); 


        System.out.println("After merging overlapping subintervals: ");
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++)
            System.out.print(ans[i][j]+",");

            System.out.println();
        }
        
        
        sc.close();
    }
    public static int[][] merge(int[][] intervals) {
        List<int []> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(s<=end){
                if(end<e)end=e;
            }
            else{
                ans.add(new int[]{start, end});
                start=s;
                end=e;
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }

}