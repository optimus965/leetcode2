package projectICPC;
import java.util.*;
class solution {
	public void multiply(int[][] a,int[][] b) {
		int[][] store = new int[2][2];
		for(int i  =0;i < a.length;i++) {
			for(int j =0;j < a.length;j++) {
				store[i][j] = 0;
				for(int k =0;k < a.length;k++) {
					store[i][j] += a[i][k]*b[k][j]; 
				}
			}
		}
		for(int  i =0;i < a.length;i++) {
			for(int j =0;j < a.length;j++) {
				a[i][j] = store[i][j];
			}
		}
	}
	public int power(int[][] matrix, int n) {
		int[][] sample = {
				{1,1,},
				{1,0}
		};
		if(n == 1 || n == 0) {
			return 1;
		}
		if(n <  0) {
			return 0;
		}
		power(matrix,n/2);
		multiply(matrix,matrix);
		if((n&1) != 0) {
			multiply(matrix,sample);
		}
		return matrix[0][0] + matrix[0][1];
	}
}
public class sol {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		solution n =new solution();
		int[][] m = {
				{1,1},
				{1,0}
		};
		int n1 = scanner.nextInt();
		System.out.println(n.power(m,n1 - 1));
	}
}
