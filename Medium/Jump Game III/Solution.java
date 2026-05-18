/*Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter start: ");
        int start = sc.nextInt();

        System.out.println(canReach(arr, start));
        sc.close();
    }
    public static boolean canReach(int[] arr, int start) {
        Queue<Integer>queue=  new LinkedList<>();
        int n =arr.length;   
        boolean vis[] = new boolean[n];
        queue.add(start);
        vis[start]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            if(arr[curr]==0)return true;
            int forward =curr+arr[curr];
            int backward =curr-arr[curr];
            if(forward>=0&&forward<n&&!vis[forward]){
                queue.add(forward);
                vis[forward]=true;
            }
            if(backward>=0&&backward<n&&!vis[backward]){
                queue.add(backward);
                vis[backward]=true;
            }
        }
        return false;
    }
}