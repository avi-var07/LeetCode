import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Majority Element is: "+majorityElement(arr));
        
        sc.close();
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        int ans = Integer.MIN_VALUE;
        for(var ele:  map.entrySet())
        if(ele.getValue()>(nums.length/2))ans=ele.getKey();
        

        return ans;
    }
}