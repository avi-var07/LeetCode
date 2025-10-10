/*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
 
 */

import java.util.*;

class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the LinkedList: ");
        int val = sc.nextInt();
        ListNode head = new ListNode(val);
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            ListNode newListNode = new ListNode(ele);
            newListNode.next = null;
            current.next = newListNode;
            current = newListNode;
        }
        print(head);

        System.out.println(isPalindrome(head));
        sc.close();
    }
    static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "  ");
            temp = temp.next;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode newHead = reversal(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second!=null){
            if(first.val!=second.val){
                reversal(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reversal(newHead);
        return true;
    }
    static ListNode reversal(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode temp=head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}