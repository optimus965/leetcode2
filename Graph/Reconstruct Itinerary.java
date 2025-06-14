// Eulerian path Circuit Based problem
class Solution {
    public void dfs(Map<String,PriorityQueue<String>> map,List<String> list,String s) {
        PriorityQueue<String> pq = map.get(s);
        while(pq != null && !pq.isEmpty()) {
            String v = pq.poll();
            dfs(map,list,v);
        }
        list.addFirst(s);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(List<String> t:tickets) {
            if(map.containsKey(t.get(0)) == false) {
                map.put(t.get(0),new PriorityQueue<>());
            }
            map.get(t.get(0)).add(t.get(1));
        }
        List<String> list = new LinkedList<>();
        dfs(map,list,"JFK");
        return list;

    }
}       
