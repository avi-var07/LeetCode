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
1 <= Node.val <= 105 */

import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }

}
class Solution{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");

        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Create LL
        ListNode head = createLL(arr);

        System.out.println("\nOriginal Linked List:");
        printLL(head);

        // Remove nodes
        head = removeNodes(head);

        System.out.println("\nModified Linked List:");
        printLL(head);

        sc.close();
    }

    public static ListNode removeNodes(ListNode head) {
        //Brute Force:

        // List<Integer>ans = new ArrayList<>();
        // ListNode temp =head;
        // while(temp!=null){
        //     ans.add(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // int n =ans.size();
        // int suffMax[] = new int[n];
        // suffMax[n-1]=ans.get(n-1);
        // for(int i=n-2;i>=0;i--)suffMax[i]=Math.max(ans.get(i), suffMax[i+1]);
        // ListNode prev=null;
        // int i=0;
        // while(temp!=null){
        //     if(temp.val!=suffMax[i++]){
        //         if(temp==head){
        //             head=head.next;
        //             temp=head;
        //         }
        //         else{
        //             prev.next=temp.next;
        //             temp=temp.next;
        //         }
        //     }
        //     else{
        //         prev=temp;
        //         temp=temp.next;
        //     }
        // }
        // return head;

        head=reverse(head);
        ListNode temp =head;
        int maxi =temp.val;

        while(temp!=null&&temp.next!=null){
            if(temp.next.val<maxi)temp.next=temp.next.next;
            else{
                temp=temp.next;
                maxi = temp.val;
            }
        }
        return reverse(head);
    }
    static ListNode reverse(ListNode head){
        ListNode temp =head;
        ListNode prev = null;

        while(temp!=null){
            ListNode nxt = temp.next;
            temp.next=prev;
            prev=temp;
            temp=nxt;
        }
        return prev;
    }
    static ListNode createLL(int arr[]) {

        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);

        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {

            temp.next = new ListNode(arr[i]);

            temp = temp.next;
        }

        return head;
    }
    static void printLL(ListNode head) {

        ListNode temp = head;

        while (temp != null) {

            System.out.print(temp.val);

            if (temp.next != null)
                System.out.print(" -> ");

            temp = temp.next;
        }

        System.out.println();
    }
}