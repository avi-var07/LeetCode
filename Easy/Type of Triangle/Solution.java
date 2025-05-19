import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the triangles length one by one: ");
        int arr[]=new int[3];
        for(int i=0;i<3;i++)arr[i]=sc.nextInt();
        String result = triangleType(arr);

        System.out.println(result);

        sc.close();
    }
    public static String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return "equilateral";
        else if ((nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
                 && nums[0] + nums[1] > nums[2]
                 && nums[1] + nums[2] > nums[0]
                 && nums[0] + nums[2] > nums[1])
            return "isosceles";
        else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]
                 && nums[0] + nums[1] > nums[2]
                 && nums[1] + nums[2] > nums[0]
                 && nums[0] + nums[2] > nums[1])
            return "scalene";
        return "none";
    }
}