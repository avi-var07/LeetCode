/*You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

Count the occurrences of all elements in the array.
Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
Calculate the sum of the resulting array.
Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

 

Example 1:

Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

Output: [6,10,12]

Explanation:

For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.
Example 2:

Input: nums = [3,8,7,8,7,5], k = 2, x = 2

Output: [11,15,15,15,12]

Explanation:

Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].

 

Constraints:

nums.length == n
1 <= n <= 105
1 <= nums[i] <= 109
1 <= x <= k <= nums.length */

import java.util.*;

class Solution{
    TreeSet<int[]>main;
    TreeSet<int[]>sec;
    long sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter size of k: ");
        int k = sc.nextInt();
        System.out.println("Enter the value of x: ");
        int x = sc.nextInt();

        Solution s = new Solution();
        long ans[] = s.findXSum(arr,k,x);
        for(long ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer>map = new HashMap<>();
        
        Comparator<int[]>comp = (a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        };
        sum=0;
        main = new TreeSet<>(comp);
        sec = new TreeSet<>(comp);

        int i=0, j=0, index=0;
        long ans[] = new long[n-k+1];
        while(j<n){
            if(map.containsKey(nums[j]))removeFromSet(new int[]{map.get(nums[j]), nums[j]}, x);

            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            insertIntoSet(new int[]{map.get(nums[j]), nums[j]}, x);

            if(j-i+1==k){
                ans[index++]=sum;
                removeFromSet(new int[]{map.get(nums[i]), nums[i]}, x);
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                else insertIntoSet(new int[]{map.get(nums[i]), nums[i]},x);

                i++;
            }
            j++;
        }
        return ans;
    }
    void insertIntoSet(int arr[], int x){
        if(main.size()<x||compare(arr, main.first())>0){
            main.add(arr);
            sum+=1L*arr[0]*arr[1];

            if(main.size()>x){
                int toRemove[] = main.first();
                sum-=1L*toRemove[0]*toRemove[1];
                main.remove(toRemove);
                sec.add(toRemove);
            }
        }
        else sec.add(arr);
    }
    void removeFromSet(int arr[], int x){
        if(main.remove(arr)){
            sum-=1l*arr[0]*arr[1];

            if(main.size()<x&&!sec.isEmpty()){
                int best[] = sec.pollLast();
                main.add(best);
                sum+=1L*best[0]*best[1];
            }
        }
        else sec.remove(arr);
    }
    int compare(int a[], int b[]){
        if(a[0]!=b[0])return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
    }
}
