import java.util.*;

class Solution {
    static int removeElement(int[] nums, int val) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=Integer.MAX_VALUE;
                c++;
            }
        }
        Arrays.sort(nums);
        return nums.length-c;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter val to be removed: ");
        int val=sc.nextInt();
        System.out.println(removeElement(arr, val));
        sc.close();
    }
}