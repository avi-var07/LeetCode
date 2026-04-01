/*There are n 1-indexed robots, each having a position on a line, health, and movement direction.

You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.

All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.

If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.

Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final health of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.

Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.

Note: The positions may be unsorted.

 
 

Example 1:



Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
Output: [2,17,9,15,10]
Explanation: No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].
Example 2:



Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
Output: [14]
Explanation: There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide, and since both have the same health, they will be removed from the line. Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed, and robot 3's health becomes 15 - 1 = 14. Only robot 3 remains, so we return [14].
Example 3:



Input: positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
Output: []
Explanation: Robot 1 and robot 2 will collide and since both have the same health, they are both removed. Robot 3 and 4 will collide and since both have the same health, they are both removed. So, we return an empty array, [].
 

Constraints:

1 <= positions.length == healths.length == directions.length == n <= 105
1 <= positions[i], healths[i] <= 109
directions[i] == 'L' or directions[i] == 'R'
All values in positions are distinct */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of posiitons: ");
        int n = sc.nextInt();

        int posiitons[] = new int[n];
        int health[] = new int[n];
        System.out.println("Enter "+n+" positions: ");
        for(int i=0;i<n;i++) posiitons[i] = sc.nextInt();
        
        System.out.println("Enter "+n+" healths: ");
        for(int i=0;i<n;i++) health[i] = sc.nextInt();

        System.out.println("Enter directions as String: ");
        String directions = sc.nextLine();

        List<Integer>ans = survivedRobotsHealths(posiitons, health, directions);

        for(int ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        // robots bana rhe:
        // [position, health, direction, originalIndex] sb ek 2D mei
        int robots[][]=new int[n][4];
        for(int i=0;i<n;i++){
            robots[i][0]=positions[i];
            robots[i][1]=healths[i];
            robots[i][2]=directions.charAt(i);
            robots[i][3]=i;
        }
        //collision order k liyen sort:
        Arrays.sort(robots, (a,b)->a[0]-b[0]);

        //stack mei daalenge saree 'R' directions k robots, kyuki poosible wohi hai collide k:
        //'R' jaa rha ek 'L' dikha to collide, otherwise not possi, to last 'R' jaane wala robot pehle collide krega, mtlb LIFO to Stack!!
        Stack<int[]>st = new Stack<>();

        for(int ele[]: robots){
            if(ele[2]=='R')st.push(ele);
            else{ //mtlb 'L' hai, to stack mei present hai to collide:
                // Keep colliding while:
                // stack not empty, stack top is R, and current robot still alive

                while(!st.isEmpty()&&st.peek()[2]=='R'&&ele[1]>0){
                    // Case 1: Stack robot weaker → stack robot dies

                    if(st.peek()[1]<ele[1]){
                        ele[1]--;   //current robot loses 1 health;
                        st.pop();   //stack robot dead, remove
                    }
                    // Case 2: Stack robot stronger → current robot dies
                    else if(st.peek()[1]>ele[1]){
                        st.peek()[1]--; //stack robot health -1
                        ele[1]=0; //current robot die   
                    }
                    else{ //dono mar gye bc
                        st.pop();
                        ele[1]=0;
                    }
                }
                // If current robot still alive after all collisions → push to stack
                if(ele[1]>0)st.push(ele);
            }
        }
        //store survivor health using original index:

        int res[] = new int[n];

        for(int ele[]: st)res[ele[3]]=ele[1];

        //final ans in ori order:

        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<n;i++)if(res[i]>0)ans.add(res[i]);

        return ans;
    }
}