import java.util.Scanner;
public class sol {
    static int[] next;
    public static int getNext(int v) {
        if(next[v] == v) {
            return v;
        }
        return next[v] = getNext(next[v]);
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int query = scanner.nextInt();
        next= new int[n + 2];
        for(int i = 1;i <= (n + 1);i++) {
            next[i] = i;
        }
        int[] answer = new int[n + 1];
        for(int i =0;i < query;i++) {
            int a= scanner.nextInt();
            int b = scanner.nextInt();
            int win = scanner.nextInt();
            int cur = getNext(a);
            while(cur <= b) {
                if(cur == win) {
                    cur += 1;
                }
                else {
                    answer[cur] = win;
                    next[cur] = cur + 1;
                }
                cur = getNext(cur);
            }
        }
        for(int i = 1;i<=n;i++) {
            System.out.print(answer[i] + "\t");
        }
    }
}
