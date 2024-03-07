class Solution
{
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        int m = pattern.length();
        int n = text.length();
        int d = 26;
        int h = 1;
        int p = 0;
        int t = 0;
        int mod = 101;
        for(int i =0; i < m - 1;i++) {
            h = (h*d)%mod;
        }
        for(int i =0;i < pattern.length();i++) {
            p = (p*d + pattern.charAt(i))%mod; 
            // 1st iteration 1
            // 2nd iteration 1*256 + 2
            // 3rd iteration ((1*256 + 2)*256) + 3
            // it is like multiplying with 10 for every time we want to add coming number
            // it like giving space for the coming number
            // ex 1
            // 1*10 + 2
            // 12*10 + 3
            // 123*10 + 4
            //1234*10 + 5
            // 12345
            t = (t*d + text.charAt(i))%mod;
        }
        int j = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i <= n- m;i++) {
            if(p == t) {
                for(j = 0;j < m;j++) {
                    if(pattern.charAt(j) != text.charAt(i + j)) {
                        break;
                    }
                }
                if(j == m) {
                    list.add(i + 1);
                }
            }
            if(i < n - m) {
                t = ((d*(t - text.charAt(i)*h)) + text.charAt(i + m))%mod;
                if (t < 0) {
                    t = (t + mod);
                }
            }
        }
        return list;
    }
}
