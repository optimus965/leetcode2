// Cycle Detection in Directed Graph
class Solution {
    public boolean canFinish(int numCourses, int[][] courses) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int n = numCourses;
        for(int i =0;i< n;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i =0;i < courses.length;i++) {
            int first = courses[i][0];
            int second = courses[i][1];
            graph[first].add(second);
        }
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i = 0;i <n;i++) {
             if(visited[i]) {
                continue;
            }
            boolean value = Cycle(graph,visited,path,i);
            if(value == true) {
                return false;
            }
        }
        return true;
    }
    public boolean Cycle(List<Integer>[] graph,boolean[] visited,boolean[] path,int index) {
        List<Integer> list = graph[index];
        visited[index] = true;
        path[index] = true;
        for(int i:list) {
            if(path[i]) {
                return true;
            }
            else if(!visited[i]) {
                if(Cycle(graph,visited,path,i)) {
                    return true;
                }
            }
        }
        path[index] = false;
        return false;
    }
}
