/*Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

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

import java.util.Scanner;

class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        int pos = len-n+1;
        if(pos==1){
            head=head.next;
            return head;
        }
        int count =0;
        while(temp!=null){
            count++;
            if(count==pos-1){
                temp.next=temp.next.next;
                break;
            }
            else temp=temp.next;
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
            ListNode temp = new  ListNode(val);
            current.next=temp;
            current = temp;
        }

        print(head);
        System.out.println();

        System.out.println("Enter the nth node to delete from end: ");
        int node = sc.nextInt();

        head = removeNthFromEnd(head, node);

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