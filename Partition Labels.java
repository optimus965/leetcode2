class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int[] parent = new int[n];
        for(int i = 0;i < n;i++) {
            parent[i] = i;
        }
        int[] lastIndex = new int[26];
        for(int i = 0;i < 26;i++) {
            lastIndex[i] = -1;
        }
        for(int i =0;i < s.length();i++) {
            int a = s.charAt(i) - 'a';
            if(lastIndex[a] != -1) {
                for(int j = lastIndex[a] + 1;j <= i && j < n;j++) {
                    parent[j] = parent[lastIndex[a]];
                }
                
            }
            lastIndex[a] = i;
        }
        int j = 0;
        int k = 0;
        int count = 0;
        while(k < n) {
            if(parent[k] == parent[j]) {
                k++;
                count++;
            }
            else {
                list.add(count);
                count = 0;
                j = k;
            }
        }
        if(count > 0) {
            list.add(count);
        }
        return list;
    }
}
