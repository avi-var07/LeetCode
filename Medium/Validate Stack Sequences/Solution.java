import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int pushed[] = new int[n];
        System.out.println("Enter "+n+" elements of pushed: ");
        for(int i=0;i<n;i++) pushed[i] = sc.nextInt();
        
        int popped[] = new int[n];
        System.out.println("Enter "+n+" elements of popped: ");
        for(int i=0;i<n;i++) popped[i] = sc.nextInt();

        System.out.println(validateStackSequences(pushed, popped));
        sc.close();
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st = new Stack<>();
        int i = 0;
        for(int ele: pushed){
            st.push(ele);
            while(!st.isEmpty()&&st.peek()==popped[i]){
                st.pop();
                i++;
            }
            
        }
        return st.isEmpty();
    }
}