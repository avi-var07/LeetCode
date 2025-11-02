/*You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] 
represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting 
from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.

  */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows for guards: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols for guards: ");
        int n = sc.nextInt();
        int guards[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)guards[i][j]=sc.nextInt();
        }
        
        System.out.println("Enter number of rows for walls: ");
        int k = sc.nextInt();
        System.out.println("Enter number of cols for guards: ");
        int l = sc.nextInt();
        int walls[][] = new int[k][l];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)walls[i][j]=sc.nextInt();
        }

        System.out.println("Number of unguarded cells: "+countUnguarded(m, n, guards, walls));
        sc.close();
    }
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count = 0;
        int grid[][] = new int[m][n];

        for(int g[]: guards)grid[g[0]][g[1]]=1;
        for(int w[]:walls)grid[w[0]][w[1]]=2;

        for(int g[]:guards){
            markUp(g[0]-1,g[1],grid, m);
            markDown(g[0]+1,g[1],grid, m);
            markLeft(g[0],g[1]-1,grid,n);
            markRight(g[0],g[1]+1,grid, n);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)count++;
            }
        }
        return count;

    }
    static void markUp(int row, int col, int grid[][], int m){
        
        while(row>=0&&grid[row][col]!=1&&grid[row][col]!=2){
            if(grid[row][col]==0)grid[row][col]=3;
            row--;
        }
    }
    static void markDown(int row, int col, int grid[][], int m){
        while(row<m&&grid[row][col]!=1&&grid[row][col]!=2){
            if(grid[row][col]==0)grid[row][col]=3;
            row++;
        }
    }
    static void markLeft(int row, int col, int grid[][], int n){
        
        while(col>=0&&grid[row][col]!=1&&grid[row][col]!=2){
            if(grid[row][col]==0)grid[row][col]=3;
            col--;
        }
    }
    static void markRight(int row, int col, int grid[][], int n){
        while(col<n&&grid[row][col]!=1&&grid[row][col]!=2){
            if(grid[row][col]==0)grid[row][col]=3;
            col++;
        }
    }
}