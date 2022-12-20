class solution {
    
    public int[] KMP_h(String pattern) {
        //return the longest common prefix of the string
        int[] lps = new int[pattern.length()];
        int i = 1;
        int len = 0;
        int m = pattern.length();
        while(i < m) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i++] = len;
            }
            else {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
    // Knuth–Morris–Pratt algorithm it considers prefix and suffix of the string
    // runs in O(n)
    public void KMP(String text,String pattern) {
        int[] preprocess_Index = this.KMP_h(pattern);
        List<Integer> list =new ArrayList<>();
        for(int i =0,j = 0;i < text.length() && j < pattern.length();) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j == pattern.length()) {
                list.add(i- j);
                j = preprocess_Index[j-1];
            }
            else if(i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0) {
                    j = preprocess_Index[j - 1];
                }
                else {
                    i = i  + 1;
                }
            }
        }
        System.out.println(list);
    }
}
