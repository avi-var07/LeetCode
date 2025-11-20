/*You are given a 2D integer array intervals where intervals[i] = [starti, endi] represents all the integers from starti to endi inclusively.

A containing set is an array nums where each interval from intervals has at least two integers in nums.

For example, if intervals = [[1,3], [3,7], [8,9]], then [1,2,4,7,8,9] and [2,3,4,8,9] are containing sets.
Return the minimum possible size of a containing set.

 

Example 1:

Input: intervals = [[1,3],[3,7],[8,9]]
Output: 5
Explanation: let nums = [2, 3, 4, 8, 9].
It can be shown that there cannot be any containing array of size 4.
Example 2:

Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
Output: 3
Explanation: let nums = [2, 3, 4].
It can be shown that there cannot be any containing array of size 2.
Example 3:

Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
Output: 5
Explanation: let nums = [1, 2, 3, 4, 5].
It can be shown that there cannot be any containing array of size 4.
 

Constraints:

1 <= intervals.length <= 3000
intervals[i].length == 2
0 <= starti < endi <= 108
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Intervals: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter start: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter end: ");
            arr[i][1] = sc.nextInt();
        }
        System.out.println(intersectionSizeTwo(arr));
        sc.close();
    }
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->
            a[1]==b[1]?b[0]-a[0]:a[1]-b[1]
        );

        int first = -1;
        int second = -1;
        int res = 0;
        for(int i[]: intervals){
            int l =i[0];
            int r = i[1];
            if(l<=first)continue;
            if(l<=second){
                res++;
                first=second;
                second= r;
            }
            else{
                res+=2;
                first = r-1;
                second =r;
            }
        }
        return res;
    }
}