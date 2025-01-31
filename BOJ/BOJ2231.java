package algorithm;

import java.io.*;

public class BOJ2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = i; 
			int sum = i;
			
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum == N) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
		br.close();
	}

}
