class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
        return this.sol(s,t);
    }
    Map<String,Boolean> map =new HashMap<>();
    Stack<Character> stack =new Stack<>();
    Pair[][] bo;
    List<String> list = new ArrayList<>();
    public List<String> sol(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        bo = new Pair[n + 1][m + 1];
        for(int i =0;i < bo.length;i++) {
            for(int j = 0;j <= m;j++) {
                bo[i][j] = new Pair();
            }
        }
        String[] v = backTrack(dp,s,t,n,m,dp[n][m]);
        for(int i = 0;i <v.length;i++) {
            if(!map.containsKey(v[i])) {
                map.put(v[i],true);
                list.add(v[i]);
            }
        }
        Collections.sort(list);
        return list;
    }
    public String[] backTrack(int[][] matrix,String s,String t,int n,int m,int count) {
        if(bo[n][m].bo == true) {
            return bo[n][m].li;
        }
        String[] string;
        if(n < count || m < count) {
            string = new String[0];
            return string;
        }
        if(count == 1 &&s.charAt(n - 1) == t.charAt(m - 1)) {
            String s1= s.charAt(n - 1) + "";
           
            String[] str = new String[1];
            str[0] = s1;
            return str;
        }
        if(n <= 0 || m <= 0 ) {
            string = new String[0];
            return string;
        }
        if(s.charAt(n - 1)== t.charAt(m  - 1)) {
            String[] string1 = backTrack(matrix,s,t,n - 1,m - 1,count - 1);
            string = new String[string1.length];
            for(int i =0;i < string.length;i++) {
               string[i] = string1[i] + s.charAt(n - 1) + "";
            }
            return string;
        }
        else {
            int max = Math.max(matrix[n - 1][m],matrix[n][m - 1]);
            int len = 0;
            Map<String,Boolean> mv = new HashMap<>();
            if(matrix[n - 1][m] == max) {
                String[] s1 = backTrack(matrix,s,t,n -1,m,count);
                for(String cb:s1) {
                    if(!mv.containsKey(cb)) {
                         mv.put(cb,true);
                    }
                }
            }
            if(matrix[n][m -1] == max) {
                String[] s1 = backTrack(matrix,s,t,n,m - 1,count);
                len += s1.length;
                for(String cb:s1) {
                    if(!mv.containsKey(cb)) {
                         mv.put(cb,true);
                         
                    }
                }
            }
            string = new String[mv.size()];
            int cou = 0;
            for(Map.Entry<String,Boolean> vb:mv.entrySet()) {
                string[cou++] = vb.getKey();
            }
        }
        bo[n][m].li = string;
        bo[n][m].bo = true;
        return string;
    }
}
class Pair {
    boolean bo = false;
    String[] li;
}
