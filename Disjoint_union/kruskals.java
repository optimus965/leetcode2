import java.util.*;

class Edge {
    int source;
    int destination;
    int cost;
    public Edge(int source, int destination,int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}
class Graph {
    List<Edge> list= new ArrayList<>();
    public Graph(int count) {
       for(int i = 0;i < count;i++) {
           list.add(new Edge(0,0,0));
       }
    }
}
class comp implements Comparator<Edge> {
    @Override
    public int compare(Edge a, Edge b) {
        return a.cost - b.cost;
    }
}
class solution {
    int vertices;
    int edges;
    int[] parent;
    int[] rank;
    Edge[] result;
    public solution(int vertices,int edges) {
        this.edges = edges;
        this.vertices = vertices;
        parent = new int[vertices];
        for(int i = 0;i < parent.length;i++) {
            parent[i] = i;
        }
        rank  = new int[vertices];
        result = new Edge[vertices-1];
        Arrays.fill(result,new Edge(0,0,0));
        Arrays.fill(rank,1);
    }
    public void sol(Graph gp) {

        int count = 0;
        for(int i =0;i < edges && count < this.vertices - 1;i++) {
            int x = find(parent,gp.list.get(i).source);
            int y = find(parent,gp.list.get(i).destination);
            if(x != y) {
                union(parent,x,y,rank);
                result[count++] = new Edge(gp.list.get(i).source,gp.list.get(i).destination,gp.list.get(i).cost);
            }
        }
        for(int i =0;i < result.length;i++) {
            System.out.println("Path at " +  i + "th  from " + result[i].source + "  to"  + "  go" + result[i].destination);

        }
    }
    public int find(int[] parent,int a) {
        if(parent[a] == a) {
            return a;
        }
        parent[a] = find(parent,parent[a]);
        return parent[a];
    }
    public void union(int[] parent,int a, int b,int[] size) {
        int x = find(parent,a);
        int y = find(parent,b);
        if(x == y) {
            return;
        }
        if(size[a] > size[b]) {
            size[a] += size[b];
            parent[b] = parent[a];
        }
        else {
            size[b] += size[a];
            parent[a] = parent[b];
        }
    }
}
public class sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph(14);
        for(int i =0;i < 14;i++) {
            graph.list.get(i).source = scanner.nextInt();
            graph.list.get(i).destination = scanner.nextInt();
            graph.list.get(i).cost = scanner.nextInt();
        }
        graph.list.sort(new comp());
        solution sol = new solution(9,14);
        sol.sol(graph);
    }
}
