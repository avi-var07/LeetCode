/*Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

 */


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
        System.out.println("After sorting: ");
        head=sortList(head);
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
    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        
        ListNode middle = tortoiseHare(head);
        ListNode rightHead = middle.next;
        ListNode leftHead = head;
        middle.next=null;
        
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        
        return merge(leftHead, rightHead);
    }
    static ListNode tortoiseHare(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode firstHead, ListNode secondHead){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        ListNode t1=firstHead;
        ListNode t2 = secondHead;
        
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                temp.next=t1;
                temp=temp.next;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                t2=t2.next;
                temp=temp.next;
            }
        }
        if(t1!=null)temp.next=t1;
        else temp.next=t2;
        
        return dummyNode.next;
    
    }
}