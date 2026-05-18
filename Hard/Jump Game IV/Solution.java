/*Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(minJumps(arr));
        sc.close();
    }
    public static int minJumps(int[] arr) {
        Queue<Integer>queue = new LinkedList<>();
        int n =arr.length;
        boolean vis[]= new boolean[n];
        queue.add(0);
        vis[0]=true;
        int steps=0;
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                if(curr==n-1)return steps;
                if(curr+1<n&&!vis[curr+1]){
                    queue.add(curr+1);
                    vis[curr+1]=true;
                }
                if(curr-1>=0&&!vis[curr-1]){
                    queue.add(curr-1);
                    vis[curr-1]=true;
                }
                //ye wala har kisi pe har baar jayega, n square bana dega
                // for(int j=0;j<n;j++){
                //     if(arr[j]==arr[curr]&&!vis[j]){
                //         queue.add(j);
                //         vis[j]=true;
                //     }
                // }

                //maintain krna pdega har element k liye uska duplicate value ka index, so using hashmap

                List<Integer>dupli = map.get(arr[curr]);
                for(int ele: dupli){
                    if(!vis[ele]){
                        queue.add(ele);
                        vis[ele]=true;
                    }
                }
                dupli.clear(); //saare element hi same hogye agar to baar baar traverse krayega?
            }
            steps++;

        }
        return -1;
    }
}