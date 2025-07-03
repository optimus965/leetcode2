class Solution {
    List<List<String>> finalString;
    public boolean check(String string1, String string2) {
        int i = 0;
        int count = 0;
        int n = string1.length();
        while (i < n) {
            if (string1.charAt(i) != string2.charAt(i)) {
                count++;
            }
            if (count == 2) {
                return false;
            }
            i++;
        }
        return true;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        finalString = new ArrayList<>();
        Queue<String> que = new ArrayDeque<>();
        que.add(beginWord);
        Map<String, Boolean> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> path = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add(beginWord);
        boolean visited = true;
        distance.put(beginWord, 1);
        path.put(beginWord, list1);
        map.put(beginWord, true);
        int count = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            if(visited) {
                count++;
            }
            for (int i = 0; i < size; i++) {
                String string = que.poll();
                if(visited && string.equals(endWord)) {
                    visited = false;
                }
                for (String word : wordList) {
                    boolean check1 = map.containsKey(word);
                    int distance1 = distance.get(string);
                    if (check(word, string)) {
                        if (check1) {
                            int distance2 = distance.get(word);
                            if (distance1 + 1 == distance2) {
                                path.get(word).add(string);
                            }
                        } else {
                            map.put(word, true);
                            distance.put(word, distance1 + 1);
                            que.add(word);
                            List<String> listc = new ArrayList<>();
                            listc.add(string);
                            path.put(word, listc);
                        }
                    }

                }
            }

        }
        Stack<String> stack = new Stack<>();
        if (!path.containsKey(endWord)) {
            return finalString;
        }
        dfs(path, endWord, beginWord, stack, count);
        return finalString;
    }

    public void dfs(Map<String, List<String>> map, String endWord, String beginWord, Stack<String> stack, int count) {
        if (count == 1) {
            stack.push(beginWord);
            List<String> reversedList = new ArrayList<>(stack);
            Collections.reverse(reversedList);
            finalString.add(reversedList);
            stack.pop();
            return;
        }
        for (String string : map.get(endWord)) {
            stack.push(endWord);
            dfs(map, string, beginWord, stack, count - 1);
            stack.pop();
        }
    }
}
