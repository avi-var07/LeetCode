/*You are given an integer array nums of length n.

You start at index 0, and your goal is to reach index n - 1.

From any index i, you may perform one of the following operations:

Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
Return the minimum number of jumps required to reach index n - 1.

 

Example 1:

Input: nums = [1,2,4,6]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index 1.
At index i = 1, nums[1] = 2 is a prime number. Therefore, we teleport to index i = 3 as nums[3] = 6 is divisible by 2.
Thus, the answer is 2.

Example 2:

Input: nums = [2,3,4,7,9]

Output: 2

Explanation:

One optimal sequence of jumps is:

Start at index i = 0. Take an adjacent step to index i = 1.
At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9 is divisible by 3.
Thus, the answer is 2.

Example 3:

Input: nums = [4,6,5,8]

Output: 3

Explanation:

Since no teleportation is possible, we move through 0 → 1 → 2 → 3. Thus, the answer is 3.
 

Constraints:

1 <= n == nums.length <= 105
1 <= nums[i] <= 106 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(minJumps(arr));
        sc.close();
    }
    public static int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return 0;

        // factor -> indices divisible by factor
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build factor map
        for (int i = 0; i < n; i++) {

            int x = nums[i];

            for (int f = 2; f * f <= x; f++) {

                if (x % f == 0) {

                    map.computeIfAbsent(f, k -> new ArrayList<>()).add(i);

                    while (x % f == 0)
                        x /= f;
                }
            }

            if (x > 1) {
                map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);

        vis[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1)
                    return jumps;

                // left
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right
                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                // teleport only if val itself is prime
                if (isPrime(val) && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    List<Integer> next = map.getOrDefault(val,
                            new ArrayList<>());

                    for (int ni : next) {

                        if (!vis[ni]) {

                            vis[ni] = true;
                            q.offer(ni);
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    static boolean isPrime(int x) {

        if (x < 2)
            return false;

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0)
                return false;
        }

        return true;
    }
}