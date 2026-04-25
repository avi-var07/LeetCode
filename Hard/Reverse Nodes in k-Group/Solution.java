/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space? */

import java.util.*;
class ListNode{
    ListNode next;
    int val;

    ListNode(int val){
        this.val=val;
        this.next = null;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");

        ListNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();
        head = obj.reverseKGroup(head, k);

        System.out.print("Result: ");
        printList(head);

        sc.close();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode groupTail = null;
        while(temp!=null){
            ListNode kthNode = find(temp, k);
            if(kthNode==null){ //aakhri group pe hai
                if(groupTail!=null)groupTail.next = temp;
                break;
            }
            ListNode nextNode=  kthNode.next; //LL nhi tutni chhaiye
            kthNode.next=null; //link tod diya
            ListNode reversedHead = reverse(temp); //poora group reverse krna hai to temp pass krenge n jo uska current head bana hua hai
            //for first group: 
            if(temp==head)head=reversedHead; //yehi se start hoga ans 
            else groupTail.next = reversedHead;

            groupTail = temp;
            temp=nextNode;

        }
        return head;
    }
    static ListNode find(ListNode head, int k){
        //if(head==null||head.next==null)return head; wrong for k>1 and group is of size 1!!
        if(head==null)return head;

        ListNode temp =head;
        int len =1;
        while(temp!=null&&len!=k){
            len++;
            temp=temp.next;
        }
        if(len!=k)return null;
        return temp;
    }
    static ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev=null;
        while(temp!=null){
            ListNode forward = temp.next;
            temp.next = prev;
            prev=temp;
            temp=forward;
        }
        return prev;
    }
    //sirf yaha print krne k liye main method se:
    
    static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}