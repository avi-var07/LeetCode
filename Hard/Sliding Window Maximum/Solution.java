import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] arr, int k){
        int index = 0;
        int n = arr.length;
        int result[]  = new int[n-k+1];
        ArrayDeque<Integer>deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<i-k+1)deque.pollFirst();

            while (!deque.isEmpty()&&arr[i]>=arr[deque.peekLast()])
            deque.pollLast();

            deque.offerLast(i);

            if(i>=k-1)result[index++]=arr[deque.peekFirst()];

        }
        return result;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[]  =new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        System.out.println("Enter the window size: ");
        int k=sc.nextInt();
        int ans[] =  maxSlidingWindow(arr, k);
        System.out.println("Maximum in each window: ");
        for(int ele:ans)System.out.print(ele+" ");
        sc.close();
    }
}