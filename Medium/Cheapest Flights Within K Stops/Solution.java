import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cities: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][3];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter cost: ");
            arr[i][2] = sc.nextInt();
        }
        System.out.println("Enter src: ");
        int src = sc.nextInt();
        System.out.println("Enter dst: ");
        int dst = sc.nextInt();
        System.out.println("Enter k: ");
        int k =sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.findCheapestPrice(n, arr, src, dst, k));
        sc.close();
    }
    class Tuple{
        int stops,dist, node;
        Tuple(int stops, int dist, int node){
            this.stops = stops;
            this.dist = dist;
            this.node= node;
        }
    }
    class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node= node;
            this.dist = dist;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>>adj =new ArrayList<>();
        //PriorityQueue<Tuple>queue = new PriorityQueue<>((a,b)->a.stops-b.stops);
        Queue<Tuple>queue = new LinkedList<>(); //kyuki stops humesha 1 se increase horha isliye PQ ki zaroorat hinhi
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int ele[]: flights)adj.get(ele[0]).add(new Pair(ele[1], ele[2]));

        queue.add(new Tuple(0,0,src)); //stops, dist, node

        dist[src]=0;
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int stops = t.stops;
            int ini = t.dist;
            int node = t.node;

            if(stops>k)continue;
            for(Pair ele: adj.get(node)){
                int newDist = ini+ele.dist;
                if(newDist<dist[ele.node]){
                    queue.add(new Tuple(stops+1, newDist, ele.node));
                    dist[ele.node]=newDist;
                }
                
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)return -1;

        return dist[dst];
    }
}