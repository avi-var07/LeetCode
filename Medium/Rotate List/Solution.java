/*Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109 */

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
        System.out.println("Enter the value of k (times to rotate): ");
        int k = sc.nextInt();

        head=rotateRight(head, k);
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
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
        ListNode temp = head;
        int len = 1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        temp.next=head;
        k%=len;
        int pos = len-k;
        int count = 0;

        temp=head;
        while(temp!=null){
            count++;
            if(count ==pos)break;
            temp=temp.next;
        }

        head=temp.next;
        temp.next=null;

        return head;

    }
}