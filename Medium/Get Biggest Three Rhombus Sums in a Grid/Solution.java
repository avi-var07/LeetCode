/*You are given an m x n integer matrix grid​​​.

A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid​​​. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:


Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.

Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.

 

Example 1:


Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
Output: [228,216,211]
Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 20 + 3 + 200 + 5 = 228
- Red: 200 + 2 + 10 + 4 = 216
- Green: 5 + 200 + 4 + 2 = 211
Example 2:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: [20,9,8]
Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 4 + 2 + 6 + 8 = 20
- Red: 9 (area 0 rhombus in the bottom right corner)
- Green: 8 (area 0 rhombus in the bottom middle)
Example 3:

Input: grid = [[7,7,7]]
Output: [7]
Explanation: All three possible rhombus sums are the same, so return [7].
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 105 */
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

        int ans[] = getBiggestThree(arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        TreeSet<Integer> ts=new TreeSet<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ts.add(grid[i][j]);
                for(int size=1;size<=Math.min(m,n);size++){
                    int sum=0;
                    boolean valid=true;
                    int x1=i,y1=j,x2=i,y2=j;
                    int dir1=-1,dir2=1;
                    int temp=0;
                    while(temp<=2*size){
                        if(Math.min(x1,x2)<0||Math.max(x1,x2)>=m||Math.min(y1,y2)<0||Math.max(y1,y2)>=n){
                            valid=false;
                            break;
                        }
                        if(x1==x2&&y1==y2){
                            sum+=grid[x1][y1];
                        }else{
                            sum+=grid[x1][y1];
                            sum+=grid[x2][y2];
                        }
                        if(temp==size){
                            dir2=dir2*dir1;
                            dir1=dir2*dir1;
                        }
                        x1--;
                        x2--;
                        y1=y1+dir1;
                        y2=y2+dir2;
                        temp++;
                    }
                    if(valid){
                        ts.add(sum);
                    }
                }
            }
        }
        List<Integer> lst=new ArrayList<>();
        while(!ts.isEmpty()&&lst.size()<3){
            lst.add(ts.getFirst());
            ts.removeFirst();
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}