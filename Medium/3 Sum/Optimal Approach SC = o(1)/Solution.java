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
        
        List<List<Integer>> ans = threeSum(arr);
        System.out.println("triplets with sum==0 are: ");
        for(List<Integer> ele: ans)
        System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(i!=0&&arr[i]==arr[i-1])continue;

            int j = i+1, k = arr.length-1;
            while(j<k){
                int sum  = arr[i]+arr[j]+arr[k];
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);

                    ans.add(temp);

                    j++;
                    k--;
                    
                    while(j<k&&arr[j]==arr[j-1])j++;
                    while(j<k&&arr[k]==arr[k+1])k--;
                }
                else if(sum<0)j++;
                else k--;
            }         

            
        }
        return ans;
    }
}