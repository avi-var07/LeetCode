/*You are given two jugs with capacities x liters and y liters. You have an infinite water supply. Return whether the total amount of water in both jugs may reach target using the following operations:

Fill either jug completely with water.
Completely empty either jug.
Pour water from one jug into another until the receiving jug is full, or the transferring jug is empty.
 

Example 1:

Input: x = 3, y = 5, target = 4

Output: true

Explanation:

Follow these steps to reach a total of 4 liters:

Fill the 5-liter jug (0, 5).
Pour from the 5-liter jug into the 3-liter jug, leaving 2 liters (3, 2).
Empty the 3-liter jug (0, 2).
Transfer the 2 liters from the 5-liter jug to the 3-liter jug (2, 0).
Fill the 5-liter jug again (2, 5).
Pour from the 5-liter jug into the 3-liter jug until the 3-liter jug is full. This leaves 4 liters in the 5-liter jug (3, 4).
Empty the 3-liter jug. Now, you have exactly 4 liters in the 5-liter jug (0, 4).
Reference: The Die Hard example.

Example 2:

Input: x = 2, y = 6, target = 5

Output: false

Example 3:

Input: x = 1, y = 2, target = 3

Output: true

Explanation: Fill both jugs. The total amount of water in both jugs is equal to 3 now.



Constraints:

1 <= x, y, target <= 103

 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x=sc.nextInt();
        System.out.println("Enter y: ");
        int y=sc.nextInt();

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println(canMeasureWater(x, y, target));
        sc.close();
    }
    public static boolean canMeasureWater(int x, int y, int target) {
        if(target>x+y)return false;
        // Set<int[]>set = new HashSet<>(); ye nhi bana skte kyuki int[] ek object hai, HashSet compare krta hai reference se, value se nhi!!

        //String mei .equals value compare krta hai, HashSet internally hashCode and .equals check krta (override hojata hai)

        //Important difference:
        //  Arrays:
        // hashCode() → memory address based
        // .equals() → reference compare
        //isliye fail
        // String
        // hashCode() → content based
        // .equals() → content compare
        // isliye perfectly kaam karta

        //==reference check krta, .equals check krta content

        //that's why:

        Set<String>set = new HashSet<>();
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int curr[]= queue.poll();
            int a=curr[0];
            int b=curr[1];

            if(a==target||b==target||a+b==target)return true;

            String state = a+","+b;

            if(set.contains(state))continue;
            set.add(state);

            queue.add(new int[]{x,b});
            queue.add(new int[]{a,y});
            queue.add(new int[]{0,b});
            queue.add(new int[]{a,0});
            
            int XY = Math.min(a, y-b); //x mei jitna paani hai (a) usse jyada daal nhi skte. Y mei jitna capacity hai usse jayada daal nhi skte!
            int YX = Math.min(b, x-a); //y mei jitna paani hai(b), X mei jitna capactiy hai usse jayda nhi!

            queue.add(new int[]{a-XY,b+XY});
            queue.add(new int[]{a+YX,b-YX});
        }

        return false;
    }
 }