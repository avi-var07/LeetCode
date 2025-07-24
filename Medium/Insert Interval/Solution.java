/*You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */

import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter interval " + (i+1) + " (start end): ");
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.print("Enter new interval (start end): ");
        int[] newInterval = new int[2];
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();

        int[][] result = insert(intervals, newInterval);
        
        System.out.println("Merged Intervals:");
        for(int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>(Arrays.asList(intervals));
        temp.add(newInterval);
        temp.sort((a,b) -> a[0]-b[0] );
        int start = temp.get(0)[0];
        int end = temp.get(0)[1];
        List<int[]> ans = new ArrayList<>();
        for(int i = 1;i<temp.size();i++){
            int s = temp.get(i)[0];
            int e = temp.get(i)[1];

            if(s<=end){
                if(end<e)end=e;
            }
            else{
                ans.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);

    }
}