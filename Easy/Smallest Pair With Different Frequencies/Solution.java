/*You are given an integer array nums.

Consider all pairs of distinct values x and y from nums such that:

x < y
x and y have different frequencies in nums.
Among all such pairs:

Choose the pair with the smallest possible value of x.
If multiple pairs have the same x, choose the one with the smallest possible value of y.
Return an integer array [x, y]. If no valid pair exists, return [-1, -1].

The frequency of a value x is the number of times it occurs in the array.

 

Example 1:

Input: nums = [1,1,2,2,3,4]

Output: [1,3]

Explanation:

The smallest value is 1 with a frequency of 2, and the smallest value greater than 1 that has a different frequency from 1 is 3 with a frequency of 1. Thus, the answer is [1, 3].

Example 2:

Input: nums = [1,5]

Output: [-1,-1]

Explanation:

Both values have the same frequency, so no valid pair exists. Return [-1, -1].

Example 3:

Input: nums = [7]

Output: [-1,-1]

Explanation:

There is only one value in the array, so no valid pair exists. Return [-1, -1].

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 
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

        int ans[] = minDistinctFreqPair(arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] minDistinctFreqPair(int[] nums) {

        Map<Integer, Integer>map = new HashMap<>();

        for(int ele: nums)map.put(ele, map.getOrDefault(ele, 0)+1);

        List<Integer>ans = new ArrayList<>(map.keySet());
        Collections.sort(ans);//smallest possible 

        for(int i=0;i<ans.size();i++){
            for(int j=i+1;j<ans.size();j++){
                int a = ans.get(i);
                int b = ans.get(j);

                if(map.get(a)!=map.get(b))return new int[]{a,b};
            }
        }
        return new int[]{-1, -1};
    }
}