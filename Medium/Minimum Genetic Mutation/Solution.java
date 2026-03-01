/*A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
 

Constraints:

0 <= bank.length <= 10
startGene.length == endGene.length == bank[i].length == 8
startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements of Bank: ");
        int n = sc.nextInt();
        String arr[] = new String[n];
        sc.nextLine();
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++)arr[i]=sc.nextLine();
        
        System.out.println("Enter start: ");
        String start = sc.nextLine();
        
        System.out.println("Enter end: ");
        String end = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.minMutation(start, end, arr));

        sc.close();
    }
    class Pair{
        String s;
        int level;
        Pair(String s, int level){
            this.s=s;
            this.level=level;
        }
    }
    public int minMutation(String start, String end, String[] bank) {
        Queue<Pair>queue = new LinkedList<>();
        Set<String>set = new HashSet<>();
        for(String ele: bank)set.add(ele);

        if(!set.contains(end))return -1;
        queue.add(new Pair(start, 0));
        char genes[] = {'A','C','G','T'};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String curr = p.s;
            int level =p.level;
            if(curr.equals(end))return level;
            char arr[] = curr.toCharArray();
            for(int i=0;i<arr.length;i++){
                char old=arr[i];
                for(int j=0;j<4;j++){
                    arr[i]=genes[j];
                    String newStr =new String(arr);
                    if(set.contains(newStr)){
                        queue.add(new Pair(newStr, level+1));
                        set.remove(newStr);
                    }
                }
                arr[i]=old;
            }
        }
        return -1;
    }
}