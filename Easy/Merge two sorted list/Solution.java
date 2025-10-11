/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 

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

        System.out.println("Enter length of the first LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the first LinkedList: ");
        int firstVal = sc.nextInt();
        ListNode firstHead = new ListNode(firstVal);
        ListNode current = firstHead;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            ListNode newNode = new ListNode(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
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
            ListNode newNode = new ListNode(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        print(secondHead);
        System.out.println();
        ListNode head = mergeTwoLists(firstHead, secondHead);
        System.out.println("After merging: ");
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp =dummyNode;

        ListNode t1= list1;
        ListNode t2= list2;

        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                temp.next = t1;
                t1=t1.next;
                temp=temp.next;
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