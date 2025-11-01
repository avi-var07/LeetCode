/*You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
 
 */

import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int val) {
        this.val = val;
    }
    public static ListNode modifiedList(int[] nums, ListNode head) {
        
        for(int ele: nums)head = deletion(head, ele);

        return head;
    }
    static ListNode deletion(ListNode head, int ele){
        if(head==null)return head;
        while(head!=null&&head.val==ele)head=head.next;
          
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            if(temp.val==ele)prev.next=temp.next;
            else prev=temp;

            temp=temp.next;
        
        }
        return head;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter number of elements of LinkedList: ");
        int m = sc.nextInt();
        ListNode head = null, tail = null;
        System.out.println("Enter " + m + " elements of LinkedList: ");
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            ListNode node = new ListNode(x);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        head = ListNode.modifiedList(arr, head);
        System.out.println("Modified LinkedList:");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        sc.close();
    }
}
