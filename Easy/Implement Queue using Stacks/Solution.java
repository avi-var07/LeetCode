/*Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
 

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        MyQueue q = new MyQueue();
        System.out.print("Enter number of operations: ");
        int ops = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Available operations: push, pop, peek, empty");

        for (int i = 0; i < ops; i++) {
            System.out.print("Enter operation: ");
            String op = sc.nextLine().toLowerCase();

            switch (op) {
                case "push":
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    q.push(val);
                    System.out.println(val + " pushed into queue");
                    break;

                case "pop":
                    if (q.empty())
                        System.out.println("Queue is empty!");
                    else
                        System.out.println("Popped element: " + q.pop());
                    break;

                case "peek":
                    if (q.empty())
                        System.out.println("Queue is empty!");
                    else
                        System.out.println("Front element: " + q.peek());
                    break;

                case "empty":
                    System.out.println("Queue empty? " + q.empty());
                    break;

                default:
                    System.out.println("Invalid operation! Try: push, pop, peek, empty");
            }
        }

        sc.close();
    }
}
class MyQueue {
    Stack<Integer>s1 = new Stack<>();
    Stack<Integer>s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        int s = s1.size();
        for(int i =0;i<s;i++)s2.push(s1.pop());

        s=s2.size();
        s1.push(x);
        for(int i =0;i<s;i++)s1.push(s2.pop());

    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        if(s1.size()==0&&s2.size()==0)return true;

        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */