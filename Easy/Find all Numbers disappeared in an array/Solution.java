import java.util.*;
class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>ans= new ArrayList<>();

        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }

        for(int j=0;j<nums.length;j++)if(nums[j]!=j+1)ans.add(j+1);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("enter elements: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        List<Integer>result= findDisappearedNumbers(arr);
        System.out.println("Numbers disappered are: ");
        for(int ele:result)
        System.out.println(ele+" ");

    }
}