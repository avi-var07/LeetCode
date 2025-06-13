// past mei koi aisa index tha jaha tak ka sum aisa tha ki waha se leke current index tak ka sum = k ho jaaye
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int arr[]= new int[n];

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter the target to check for subarray sum: ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays with sum equals K is: "+subarraySum(arr, k));
        sc.close();
    }
    public static int subarraySum(int[] nums, int k) {
        int prefixSum=0, count=0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            if(prefixSum==k)count++;    //agar prefixSum hi k hojaye to count++

            int  remaining = prefixSum-k;    // Check agar prefixSum - k pehle aaya hai to count mein add karo

            if(map.containsKey(remaining))count+=map.get(remaining);    // Map mein prefix sum ko store karo

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }        
        return count;
    }
}