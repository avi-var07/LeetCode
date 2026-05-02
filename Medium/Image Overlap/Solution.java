/*You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.

Return the largest possible overlap.

 

Example 1:


Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

Example 2:

Input: img1 = [[1]], img2 = [[1]]
Output: 1
Example 3:

Input: img1 = [[0]], img2 = [[0]]
Output: 0
 

Constraints:

n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] is either 0 or 1.
img2[i][j] is either 0 or 1. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int n= sc.nextInt();

        int arr1[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements of arr1: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr1[i][j] = sc.nextInt();
        }
        int arr2[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements of arr2: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr2[i][j] = sc.nextInt();
        }

        System.out.println(largestOverlap(arr1, arr2));
        sc.close();
    }
    public static int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        Set<String>set = new HashSet<>();
        Queue<int[]>queue = new LinkedList<>();

        set.add("0,0");
        queue.add(new int[]{0,0});

        int maxi =Integer.MIN_VALUE;
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1, 1};
        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            int row=curr[0];
            int col=curr[1];

            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int nrow = row+i;
                    int ncol=col+j;

                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<n){
                        if(img1[i][j]==1&&img2[nrow][ncol]==1)cnt++;
                    }
                }
            }
            maxi = Math.max(maxi, cnt);


            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol =col+dcol[i];

                String str = nrow+","+ncol;
                if(nrow>=-n&&ncol>=-n&&nrow<=n&&ncol<=n&&!set.contains(str)){
                    queue.add(new int[]{nrow, ncol});
                    set.add(str);
                }
            }

        }
        return maxi;
    }
}