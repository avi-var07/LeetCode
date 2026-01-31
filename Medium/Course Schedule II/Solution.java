/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct. */
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
        
        int ans[] = findOrder(n, arr);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] findOrder(int numCourses, int[][] arr) {
        int indegree[] = new int[numCourses];

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());

        for(int e[]: arr){
            adj.get(e[0]).add(e[1]);

            indegree[e[1]]++;
        }

        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)if(indegree[i]==0)queue.add(i);

        int count =0;
        int ans[] = new int[numCourses];
        int index=numCourses-1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[index--]=node;
            count++;
            for(int ele: adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0)queue.add(ele);
            }
        }
        if(count==numCourses) return ans; //topo sort lg gaya, cycle nhi hai
        
        return new int[]{};
    }
}