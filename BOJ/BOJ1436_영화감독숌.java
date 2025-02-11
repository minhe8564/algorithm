package algorithm;

import java.io.*;

public class BOJ1436_영화감독숌 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count = 1;
		while(true) {
			if(count == N) break;
			num++;
			
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		
		System.out.println(num);
	}

}
