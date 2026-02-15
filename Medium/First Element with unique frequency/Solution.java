/*You are given an integer array nums.

Return an integer denoting the first element (scanning from left to right) in nums whose frequency is unique. That is, no other integer appears the same number of times in nums. If there is no such element, return -1.

 

Example 1:

Input: nums = [20,10,30,30]

Output: 30

Explanation:

20 appears once.
10 appears once.
30 appears twice.
The frequency of 30 is unique because no other integer appears exactly twice.
Example 2:

Input: nums = [20,20,10,30,30,30]

Output: 20

Explanation:

20 appears twice.
10 appears once.
30 appears 3 times.
The frequency of 20, 10, and 30 are unique. The first element that has unique frequency is 20.
Example 3:

Input: nums = [10,10,20,20]

Output: -1

Explanation:

10 appears twice.
20 appears twice.
No element has a unique frequency.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        System.out.println(firstUniqueFreq(arr));
        
        sc.close();
    }
    public static int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer>map =new LinkedHashMap<>();
        for(int ele: nums)map.put(ele, map.getOrDefault(ele, 0)+1);
        Map<Integer, Integer>freq = new HashMap<>();
        for(int ele: map.values())freq.put(ele, freq.getOrDefault(ele,0)+1);
        
        // int key=-1;
        // for(var ele: freq.entrySet()){
        //     if(ele.getValue()==1){
        //         key=ele.getKey();
        //         break;
        //     }
        // }

        // for(var ele: map.entrySet())if(ele.getValue()==key)return ele.getKey();

        for(var ele: map.entrySet()){
            if(freq.get(ele.getValue())==1)return ele.getKey();
        }

        return -1;
    }
}