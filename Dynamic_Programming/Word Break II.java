class Solution {
    List<String> finalList;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        for(String word:wordDict) {
            map.put(word,true);
        }
        finalList =new ArrayList<>();
        int n = s.length();
        boolean[] dp = new boolean[s.length() + 1];
        List<Integer>[] parent = new ArrayList[n + 1];
        for(int i =0;i <= n;i++) {
            parent[i] = new ArrayList<>();
        }
        dp[0] = true;
        for(int i = 0;i < n;i++) {
            for(int j = i + 1;j <= n;j++) {
                if(!dp[i]) continue;
                if(map.containsKey(s.substring(i,j))) {
                    dp[j] = true;
                    parent[j].add(i);
                }
            }
        }
        Stack<String> stack = new Stack<>();
        dfs(parent,s,n,stack);
        return finalList;
    }
    public void dfs(List<Integer>[] parent,String s,int index,Stack<String> stack) {
        if(index == 0) {
            List<String> list = new ArrayList<>(stack);
            Collections.reverse(list);
            String string = String.join(" ",list);
            finalList.add(string);
            return;
        }
        for(int i:parent[index]) {
            stack.push(s.substring(i,index));
            dfs(parent,s,i,stack);
            stack.pop();
        }
    }
}
