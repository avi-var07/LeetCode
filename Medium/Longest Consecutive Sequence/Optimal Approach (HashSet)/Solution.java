
/*Sort ki zarurat nahi.

Ek HashSet banao jisme saare numbers daal do.

Har number ke liye check karo:

Kya num-1 exist karta hai? Agar nahi karta, to ye sequence ka start ho sakta hai.

Ab num+1, num+2, ... check karte jao jab tak HashSet mein mile.

Length count karte jao. */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Longest Consecutive Sequence is: "+longestConsecutive(arr));
        sc.close();
    }
    public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) 
    set.add(num);
    

    int longest = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) {  // Start of sequence
            int currentNum = num;
            int count = 1;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                count++;
            }

            if(count>longest)longest=count;
        }
    }

    return longest;
}

}