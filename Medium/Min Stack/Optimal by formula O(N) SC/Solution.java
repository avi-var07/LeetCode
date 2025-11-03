/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();
        int choice;

        System.out.println("=== MinStack Implementation ===");
        System.out.println("1. Push element");
        System.out.println("2. Pop element");
        System.out.println("3. Get top element");
        System.out.println("4. Get minimum element");
        System.out.println("5. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    minStack.push(val);
                    System.out.println(val + " pushed to stack.");
                    break;

                case 2:
                    minStack.pop();
                    System.out.println("Top element popped.");
                    break;

                case 3:
                    if (!minStack.isEmpty())
                        System.out.println("Top element: " + minStack.top());
                    else
                        System.out.println("Stack is empty!");
                    break;

                case 4:
                    if (!minStack.isEmpty())
                        System.out.println("Minimum element: " + minStack.getMin());
                    else
                        System.out.println("Stack is empty!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
class MinStack {
    Stack<Long>st = new Stack<>();
    long mini = Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            mini=val;
        }
        else if(val<mini){
            long newVal = 2L*val-mini;
            st.push(newVal);
            mini=val;
        }
        else st.push((long)val);
    }
    
    public void pop() {
        long popped = st.pop();
        if(popped<mini)mini = 2*mini - popped;
    }
    
    public int top() {
        long top = st.peek();
        if(top<mini)return (int)(mini);
        else return (int)(top);
    }
    
    public int getMin() {
        return (int)(mini);
    }
    public boolean isEmpty(){
        return st.size()==0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */