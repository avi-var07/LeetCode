/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104. */
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists: ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();

            if (n == 0) {
                lists[i] = null;
                continue;
            }

            System.out.println("Enter " + n + " sorted elements:");

            ListNode head = new ListNode(sc.nextInt());
            ListNode temp = head;

            for (int j = 1; j < n; j++) {
                temp.next = new ListNode(sc.nextInt());
                temp = temp.next;
            }

            lists[i] = head;
        }

        Solution obj = new Solution();
        ListNode ans = obj.mergeKLists(lists);

        System.out.println("Merged List:");
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }

        sc.close();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;

        return partition(0, n - 1, lists);
    }

    ListNode partition(int start, int end, ListNode arr[]) {
        if (start == end) return arr[start];

        int mid = start + (end - start) / 2;

        ListNode L1 = partition(start, mid, arr);
        ListNode L2 = partition(mid + 1, end, arr);

        return merge(L1, L2);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }
}