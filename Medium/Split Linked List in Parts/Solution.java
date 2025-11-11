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
        
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        ListNode ans[] = splitListToParts(head, k);

        for(var ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static void print(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int mini = len/k;
        int extra = len%k;

        ListNode[] ans= new ListNode[k];

        temp= head;

        for(int i = 0;i<k;i++){
            ans[i] = temp;

            int size = mini+(extra>0?1:0);
            extra--;

            for(int j=0;j<size-1&&temp!=null;j++)temp=temp.next;
            
            if(temp!=null){
                ListNode newNode = temp.next;
                temp.next=null;
                temp=newNode;
            }

        }
        return ans;
    }



}