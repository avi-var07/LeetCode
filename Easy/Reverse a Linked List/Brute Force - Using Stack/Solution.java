/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */
import java.util.Scanner;
import java.util.Stack;

class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data=data;
        this.next = null;
    }
}

class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp=head;
        
        while(temp!=null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" elements: ");
        int headValue = sc.nextInt();
        ListNode head = new ListNode(headValue);
        ListNode current = head;

        for(int i=1;i<n;i++){
            int val = sc.nextInt();
            ListNode temp = new ListNode(val);
            current.next = temp;
            current = temp ;
        }

        print(head);
        System.out.println();

        head = reverseList(head);
        print(head);
        sc.close();
    }

    static void print(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}