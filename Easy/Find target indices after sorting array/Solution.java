import java.util.*;

class Solution {
    static List<Integer> targetIndices(int[] nums, int target) {
        ArrayList <Integer> arr = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]==target)
            arr.add(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();

        int arr[]=new int[n];
        System.out.println("Enter the array elements: ");

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter target to be searched for: ");
        int target =  sc.nextInt();

        System.out.println(targetIndices(arr, target));

        sc.close();
    }
}