import java.util.*;
class Solution {
    public static int singleNumber(int[] arr) {
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        int ans = 0;
        for(var ele : map.entrySet()){
            if(ele.getValue()==1)
            ans = ele.getKey();
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array (odd only):");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array (each element three times and only 1 element one time):");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Single number is: "+singleNumber(arr));
        sc.close();
    }
}