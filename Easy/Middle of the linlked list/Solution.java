/*Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
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
        this.next= null;
    }
}
class Solution {
    public static ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
    
        temp =head;
        for(int i=1;i<=len/2;i++)temp=temp.next;

        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements of the LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n + " elements: ");
        int headValue = sc.nextInt();

        ListNode head = new ListNode(headValue);
        ListNode temp = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            ListNode newNode = new ListNode(ele);
            temp.next = newNode;
            temp=newNode;
        }
        print(head);
        System.out.println();
        head = middleNode(head);
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