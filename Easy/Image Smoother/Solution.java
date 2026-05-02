/*An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).


Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.

 

Example 1:


Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Example 2:


Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 

Constraints:

m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        int ans[][] = imageSmoother(arr);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }
        sc.close();
    }
    public static int[][] imageSmoother(int[][] img) {
        int m= img.length; //rows
        int n=img[0].length; //columns

        int ans[][] = new int [m][n];

        int drow[] = {-1, -1, -1, 0, 0,1,1,1}; //NW, N, NE, E, SE, S, SW, W
        int dcol[] = {-1, 0, 1, -1, 1,-1, 0, 1}; //NW, N, NE, E, SE, S, SW, W

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=img[i][j];
                int cnt=1;

                for(int k=0;k<8;k++){
                    int nrow = i+drow[k];
                    int ncol=j+dcol[k];

                    if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n){
                        sum+=img[nrow][ncol];
                        cnt++;

                    }
                }
            ans[i][j]=sum/cnt;

            }
        }
        return ans;
    }
}