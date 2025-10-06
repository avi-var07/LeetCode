/*There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.
Custom testing:

For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
We will build the linked list and pass the node to your function.
The output will be the entire list after calling your function. */




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Scanner;
class ListNode{
    ListNode next;
    int val;

    ListNode(int val){
        this.val = val;
        this.next=null;
    }
}
class Solution {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the LinkedList: ");

        int n = sc.nextInt();

        System.out.println("Enter "+n+ " elements of the LinkedList: ");
        int val = sc.nextInt();
        ListNode head = new ListNode(val);
        ListNode current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            ListNode newNode = new ListNode(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }

        System.out.println("Enter node to delete: ");
        int nodeValue = sc.nextInt();
        
        ListNode node = findNode(head, nodeValue);


        deleteNode(node);

        print(head);
        
        sc.close();

    }
    static ListNode findNode(ListNode head, int val){
        ListNode temp = head;
        while(temp!=null &&temp.next!=null){
            if(temp.val==val)return temp; //kyuli last node ko delete nhi krskte leetCode mei condition mei
            temp=temp.next;
        }
        return null;
    }
    static void print(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+"  ");
            temp=temp.next;
        }
    }
}