/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros. */

import java.util.Scanner;

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

       System.out.println("Enter length of the first LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the first LinkedList: ");
        int firstVal = sc.nextInt();
        ListNode firstHead = new ListNode(firstVal);
        ListNode current = firstHead;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            ListNode newListNode = new ListNode(ele);
            newListNode.next = null;
            current.next = newListNode;
            current = newListNode;
        }
        print(firstHead);
        System.out.println();
        System.out.println("Enter length of the second LinkedList: ");
        int m = sc.nextInt();

        System.out.println("Enter " + m + " elements of the first LinkedList: ");
        int secondVal = sc.nextInt();
        ListNode secondHead = new ListNode(secondVal);
        current = secondHead;
        for (int i = 1; i < m; i++) {
            int ele = sc.nextInt();
            ListNode newListNode = new ListNode(ele);
            newListNode.next = null;
            current.next = newListNode;
            current = newListNode;
        }
        print(secondHead);
        System.out.println();
        System.out.println("Addition of the two numbers is: ");
        ListNode head= addTwoNumbers(firstHead, secondHead);
        print(head);
        sc.close();
    }
    static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "  ");
            temp = temp.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        ListNode t1 = l1;
        ListNode t2 =l2;
        while(t1!=null||t2!=null){
            int sum = carry;

            if(t1!=null)sum+=t1.val;
            if(t2!=null)sum+=t2.val;

            ListNode newNode = new ListNode(sum%10);
            current.next=newNode;
            current=newNode;
            carry = sum/10;

            if(t1!=null)t1=t1.next;
            if(t2!=null)t2=t2.next;

        }

        if(carry!=0){
            ListNode newNode = new ListNode (carry);
            current.next=newNode;
            current= newNode;
        }

        return dummyNode.next;
    }
}