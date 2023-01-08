import java.util.Scanner;
public class Binary_Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicles = scanner.nextInt();
        int wheels = scanner.nextInt();
        int low =0;
        int high = vehicles;
        while(low <= high) {
            int mid = low + ((high - low)/2);
            int sum  = 4*mid + (vehicles - mid)*2;
            if(sum == wheels) {
                System.out.println(mid + "\t" + (vehicles - mid));
                break;
            }
            if(sum > wheels) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
    }
}
