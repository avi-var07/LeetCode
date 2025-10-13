/*You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100 */
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
        System.out.println("Enter value of k: ");
        int k =sc.nextInt();
        head = swapNodes(head, k);
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
    public static ListNode swapNodes(ListNode head, int startPos) {
        ListNode start = head;
        ListNode end = head;
        int len = getLen(head);
        int endPos = len-startPos+1;
        
        for(int i=1;i<startPos;i++)start=start.next;
        for(int i=1;i<endPos;i++)end=end.next;
        int temp = start.val;
        start.val = end.val;
        end.val = temp;

        return head;

    }
    static int getLen(ListNode head){
        ListNode temp =head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
}