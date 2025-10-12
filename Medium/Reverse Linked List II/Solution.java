/*Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?
 
 */

import java.util.Scanner;

class ListNode {
    ListNode next;
    int data;

    ListNode(int data) {
        this.data = data;
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
            ListNode newNode = new ListNode(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        print(head);
        System.out.println();
        System.out.println("Enter value of left: ");
        int left = sc.nextInt();
        System.out.println("Enter value of right: ");
        int right = sc.nextInt();

        System.out.println("After reversing between left and right: ");
        head = reverseBetween(head, left, right);

        print(head);
        sc.close();
    }
    static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null)return head;

        ListNode temp = head;
        ListNode prev = null;
        int count=0;
        while(temp!=null){
            count++;
            if(count==left)break;
            prev=temp;
            temp=temp.next;
        }
        ListNode reconnect = prev;
        ListNode tail = temp;

        while(count<=right&&temp!=null){
            ListNode front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
            count++;
        }
        if(reconnect!=null)reconnect.next=prev;
        else head=prev;
        tail.next=temp;
        return head;

    }
}