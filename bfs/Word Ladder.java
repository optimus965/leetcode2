class Solution {
    public boolean check(String string1, String string2) {
        int count = 0;
        int n = string1.length();
        int i =0;
        while(i <  n) {
            if(string1.charAt(i) != string2.charAt(i)) {
                count++;
            }
            if(count == 2) {
                return false;
            }
            i++;
        }
        return true;
    } 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        Map<String,Boolean> map =new HashMap<>();
        map.put(beginWord,true);
        while(!que.isEmpty()) {
            count++;
            int size = que.size();
            for(int i =0;i < size;i++) {
                String peek = que.peek();
                String string1 = que.poll();
                if(string1.equals(endWord)) {
                return count;
            }
                for(String word:wordList) {
                    if(map.containsKey(word)) {
                        continue;
                    }
                    if(check(peek,word)) {
                        que.add(word);
                        map.put(word,true);
                    }
                }
            }
        }
        return 0;
    }
}
