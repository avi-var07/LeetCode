/*You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.
Example 2:


Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.
 

Constraints:

1 <= m, n <= 105
1 <= m * n <= 105
The number of nodes in the list is in the range [1, m * n].
0 <= Node.val <= 1000 */
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
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        System.out.println("Enter number of nodes: ");
        int size = sc.nextInt();

        System.out.println("Enter linked list elements:");
        ListNode head = createList(sc, size);

        Solution obj = new Solution();
        int[][] ans = obj.spiralMatrix(m, n, head);

        System.out.println("Spiral Matrix:");
        for (int[] row : ans) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
    public static ListNode createList(Scanner sc, int size) {
        if (size == 0) return null;

        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;

        for (int i = 1; i < size; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        return head;
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode temp =head;
        int top=0, left=0, down=m-1, right=n-1;
        int ans[][] = new int[m][n];
        for(int ele[]: ans)Arrays.fill(ele, -1);
        while(temp!=null&&top<=down&&left<=right){
            //left se right, top fix:
            for(int i=left; i<=right;i++){
                if(temp==null)continue;
                ans[top][i]=temp.val;
                temp=temp.next;
            }
            top++;
            //upar se niche, right fix:
            for(int i=top;i<=down;i++){
                if(temp==null)continue;
                ans[i][right]=temp.val;
                temp=temp.next;
            }
            right--;
            //right se left and down fix
            if(top<=down){
                for(int i=right;i>=left;i--){
                    if(temp==null)continue;
                    ans[down][i]=temp.val;
                    temp=temp.next;
                }
            }
            down--;
            //niche se upar left fix:
            if(left<=right){
                for(int i=down;i>=top;i--){
                    if(temp==null)continue;
                    ans[i][left]=temp.val;
                    temp=temp.next;
                }
            }
            left++;
        }
        return ans;
    }
}