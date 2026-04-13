// The distance[n][k+1] table is the DP table — distance[i][j] stores the minimum cost to reach node i using exactly j edges. You're filling it optimally using the priority queue to guide the order of relaxation.
// So your solution is actually Dijkstra + DP combined:

// The PQ drives which state to process next (Dijkstra's greedy ordering)
// The 2D distance table is the memoization/DP structure storing optimal subproblem results
// one of my favourite question
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k + 1;
        boolean[][] visited = new boolean[n][k + 1];
        int[][] distance = new int[n][k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        List<List<Node>> list = new ArrayList<>();
        for(int i =0;i < n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i =0;i< flights.length;i++) {
            int x = flights[i][0];
            int y = flights[i][1];
            int weight = flights[i][2];
            list.get(x).add(new Node(y,weight));
        }
        pq.offer(new int[]{src, 0, 0});
        for(int i =0 ;i < n;i++) {
            for(int j = 0; j <=k;j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[src][0] = 0; 
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int starting =node[0];
            int stepCount = node[1];
            int distanceOfSource = node[2];
            List<Node> list1 = list.get(starting);
            if(stepCount >= k || visited[starting][stepCount]) {
                continue;
            }
            visited[starting][stepCount] = true;
            for(Node i:list1) {
                int stepCountFromSource = stepCount + 1;
                int distanceFromSource = distanceOfSource + i.weight;
                if(distanceFromSource < distance[i.destination][stepCountFromSource]) {
                    distance[i.destination][stepCountFromSource] = distanceFromSource;
                    pq.offer(new int[]{i.destination,stepCountFromSource,distanceFromSource});
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i  = 0;i <= k;i++) {
            min = Math.min(distance[dst][i],min);
        }
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
class Node {
    int destination;
    int weight;
    public Node(int destination,int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
