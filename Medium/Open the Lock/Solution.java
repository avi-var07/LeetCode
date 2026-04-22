/*You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation: 
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation: We cannot reach the target without getting stuck.
 

Constraints:

1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target will not be in the list deadends.
target and deadends[i] consist of digits only. */


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();
        sc.nextLine();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextLine();

        System.out.println("Enter target: ");
        String target = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.openLock(arr, target));

        sc.close();
    }
    class Pair{
        String str;
        int steps;

        Pair(String str, int steps){
            this.str=str;
            this.steps=steps;
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String>vis=new HashSet<>();
        for(String ele: deadends)vis.add(ele);

        String start="0000";
        if(vis.contains(start))return -1;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        vis.add(start);
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String rem = p.str;
            int steps =p.steps;
            if(rem.equals(target))return steps;
            char curr[] = rem.toCharArray();
            for(int i=0;i<4;i++){
                char ori = curr[i];
                int ch = curr[i]-'0';
                int inc = ch==9?0:ch+1;
                int dec = ch==0?9:ch-1;
                curr[i]=(char)(inc+'0');
                String newStr = new String(curr);
                if(!vis.contains(newStr)){
                    queue.add(new Pair(newStr, steps+1));
                    vis.add(newStr);
                }
                curr[i]=(char)(dec+'0');
                String newStr2 = new String(curr);
                if(!vis.contains(newStr2)){
                    queue.add(new Pair(newStr2, steps+1));
                    vis.add(newStr2);
                }
                curr[i]=ori;
                
            }
        }
        return -1;
    }
}