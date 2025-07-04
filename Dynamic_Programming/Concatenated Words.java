class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Map<String,Boolean> map =new HashMap<>();
        for(String word:words) {
            map.put(word,true);
        }
        boolean[] dp;
        List<String> list =new ArrayList<>();
        for(String word:words) {
            int n = word.length();
            dp = new boolean[n + 1];
            dp[0] = true;
            for(int i = 0;i < n;i++) {
                if(!dp[i]) continue;
                for(int j = i + 1;j <= n;j++) {
                    String string = word.substring(i,j);
                    // (j - 1 < n) this condition make sure that there will be two different unique words
                    if(j - i < n && map.containsKey(string)) {
                        dp[j] = true;
                    }
                }
            }
            if(dp[n]) {
                list.add(word);
            }
        }
        return list;
    }
}
