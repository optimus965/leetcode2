import java.util.Scanner;
public class Ternary_Search {
    public static void main(String[] args)  {
         Scanner scanner = new Scanner(System.in);
         int vehicles = scanner.nextInt();
         int wheels = scanner.nextInt();
         int low = 0;
         int high = vehicles;
         while(low <= high) {
             int mid1 = low + (high - low)/3;
             int mid2 = high - (high - low)/3;
             int sum1 = 4*mid1 + (vehicles-mid1)*2;
             int sum2 = 4*mid2 + (vehicles - mid2)*2;
             if(sum1 == wheels) {
                 System.out.println(mid1 + "\t" + (vehicles - mid1));
                 break;
             }
             if(sum2 == wheels) {
                 System.out.println(mid2 + "\t" + (vehicles - mid2));
             }
             if(sum1 > wheels) {
                 high = mid1 - 1;
             }
             else if(sum2 < wheels) {
                 low = mid2 + 1;
             }
             else {
                 low = mid1 + 1;
                 high = mid2 - 1;
             }
         }
    }
}
