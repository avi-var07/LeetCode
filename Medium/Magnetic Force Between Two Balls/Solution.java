/*In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

 

Example 1:


Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
Example 2:

Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.
 

Constraints:

n == position.length
2 <= n <= 105
1 <= position[i] <= 109
All integers in position are distinct.
2 <= m <= position.length */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter m: ");
        int m =sc.nextInt();

        System.out.println(maxDistance(arr, m));
        sc.close();
    }

    public static int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int n =arr.length;
        int low=1;
        
        int high=arr[n-1]-arr[0];
        
        int ans = Integer.MIN_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(mid, arr, m, n)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    static boolean possible(long mid, int arr[], int m, int n){
        int lastBall = arr[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(arr[i]-lastBall>=mid){
                cnt++;
                lastBall=arr[i];
            }
            if(cnt>=m)return true;
        }
        return false;
    }
}