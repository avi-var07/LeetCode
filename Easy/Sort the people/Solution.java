/*You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

 

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of people: ");
        int n  =sc.nextInt();

        int heights[] = new int[n];


        String names[] = new String[n];

        System.out.println("Enter the heights: ");
        for(int i=0;i<n;i++)
        heights[i]=sc.nextInt();

        System.out.println("Enter the names: ");
        
         sc.nextLine();

        for(int i=0;i<n;i++)
        names[i]=sc.nextLine();

        

        String result[] = sortPeople(names, heights);

        for(String ele: result)
        System.out.print(ele+" ");
        sc.close();
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> mp  = new HashMap<>();

        for(int i = 0;i< names.length;i++)
        mp.put(heights[i], names[i]);

        Arrays.sort(heights);

         int i = 0, j = heights.length - 1;
        while (i < j) {
            int temp = heights[i];
            heights[i] = heights[j];
            heights[j] = temp;
            i++;
            j--;
        }

        String ans[] = new String[names.length];

        for(int k=0;k<heights.length;k++)
        ans[k]=mp.get(heights[k]);


        return ans;

    }
}