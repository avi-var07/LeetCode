/*You are given a 2D integer array points, where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.

A horizontal trapezoid is a convex quadrilateral with at least one pair of horizontal sides (i.e. parallel to the x-axis). Two lines are parallel if and only if they have the same slope.

Return the number of unique horizontal trapezoids that can be formed by choosing any four distinct points from points.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: points = [[1,0],[2,0],[3,0],[2,2],[3,2]]

Output: 3

There are three distinct ways to pick four points that form a horizontal trapezoid:

Using points [1,0], [2,0], [3,2], and [2,2].
Using points [2,0], [3,0], [3,2], and [2,2].
Using points [1,0], [3,0], [3,2], and [2,2].
Example 2:

Input: points = [[0,0],[1,0],[0,1],[2,1]]

Output: 1

There is only one horizontal trapezoid that can be formed.

 

Constraints:

4 <= points.length <= 105
–108 <= xi, yi <= 108
All points are pairwise distinct.*/
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("x: ");
            arr[i][0] = sc.nextInt();
            System.out.println("y: ");
            arr[i][1] = sc.nextInt();
        }
        System.out.println(countTrapezoids(arr));
        sc.close();
    }
    public static int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele[]: points)map.put(ele[1], map.getOrDefault(ele[1],0)+1);

        long ans = 0;
        long MOD = 1000000007;
        long prev = 0;
        for(int ele: map.values()){
            long lines = (long)ele*(ele-1)/2;
            ans=(ans+(lines*prev)%MOD)%MOD;
            prev=(prev+lines)%MOD;
        }
        return (int)(ans%MOD);
    }
}