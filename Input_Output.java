import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
	            new OutputStreamWriter(System.out));
		long n = Integer.parseInt(reader.readLine());
		while(n != 1) {
			bufferedWriter.write(n + " ");
			if(n%2 == 0) {
				n = n/2;
			}
			else {
				n = n*3 + 1;
			}
		}
		bufferedWriter.write("1");
		bufferedWriter.flush();
	}
}
