import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(trap(arr));
        
        sc.close();
    }
    public static int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int p[] = new int[n];
        int s[] = new int[n];
        p[0] = height[0];
        s[n-1]=height[n-1];
        for(int i=1;i<n;i++)p[i] = Math.max(p[i-1], height[i]);
        for(int i=n-2;i>=0;i--)s[i] = Math.max(s[i+1], height[i]);

        for(int i=0;i<n;i++){
            int leftMax = p[i], rightMax=s[i];
            if(height[i]<leftMax&&height[i]<rightMax)total+=Math.min(leftMax, rightMax)-height[i];
        }
        return total;
        
    }
}