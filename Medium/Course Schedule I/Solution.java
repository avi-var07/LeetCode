/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(canFinish(n, arr));

        sc.close();
    }
    public static boolean canFinish(int numCourses, int[][] arr) {
        int indegree[] = new int[numCourses];

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());

        for(int e[]: arr){
            adj.get(e[0]).add(e[1]);

            indegree[e[1]]++;
        }

        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)if(indegree[i]==0)queue.add(i);


        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int ele: adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0)queue.add(ele);
            }
        }

        if(count==numCourses)return true; //mtlb topo sort lg gaya, mtlb cycle nhi hai, mtlb true
        
        return false;
    }
}