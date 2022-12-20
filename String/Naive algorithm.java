class solution {
    //Naive approach runs in O(n^2)
    public void Naive_approach(String pattern,String text) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> list =new ArrayList<>();
        for(int  i =0 ;i <= n-m;i++) {
            int j = 0;
            for(j = 0;j < m;j++) {
                if(text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if(j == m) {
                list.add(i);
            }
        }
        System.out.println(list);
        return;
    }
}
