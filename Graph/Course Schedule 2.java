// Cycle Detection in Directed Graph + Topological Sort
class Solution {
    List<Integer>[] graph;
    List<Integer> list1;
    public int[] findOrder(int numCourses, int[][] courses) {
        boolean canFinish= this.canFinish(numCourses,courses);
        if(!canFinish) {
            return new int[]{};
        }
        if(courses.length == 0) {
            int[] nums  = new int[numCourses];
            for(int i = 0;i < nums.length;i++) {
                nums[i] = i;
            }
            return nums;
        }
        list1 = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for(int i =0;i < numCourses;i++) {
            if(!visited[i]) {
                recur(graph,i,visited);
            }
        }
        int[] order = new int[list1.size()];
        for(int i =0;i < list1.size();i++) {
            order[i] = list1.get(i);
        }
        return order;
    }
    public void recur(List<Integer>[] graph,int index,boolean[] visited) {
        List<Integer> l  = graph[index];
        visited[index] =true;
        for(int i:l) {
            if(visited[i]) continue;
            recur(graph,i,visited);
        }
        list1.add(index);
    }
    public boolean canFinish(int numCourses, int[][] courses) {
        graph = new ArrayList[numCourses];
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
