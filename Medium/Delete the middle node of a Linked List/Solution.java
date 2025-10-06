/*You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:


Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 
Example 2:


Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.
Example 3:


Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 

Constraints:

The number of nodes in the list is in the range [1, 105].
1 <= Node.val <= 105
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
    ListNode next;
    int data;

    ListNode(int data){
        this.data = data;
        this.next=null;
    }
}
class Solution {
    public static ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp = head;

        int pos = len/2, count = 0;

        if(pos==0){
            head=head.next;
            return head;
        }

        while(temp!=null){
            count++;

            if(count==pos){
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
        int headVal = sc.nextInt();

        ListNode head = new ListNode(headVal);

        ListNode current = head;

        for(int i=1;i<n;i++){
            int ele =sc.nextInt();

            ListNode temp = new ListNode(ele);
    
            current.next=temp;
            current = temp;
        }

        deleteMiddle(head);

        print(head);

        sc.close();
    }

    static void print(ListNode head){
        ListNode temp = head;

        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }

    }

}