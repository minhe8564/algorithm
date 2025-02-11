package algorithm;

import java.io.*;

public class BOJ2839_설탕배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int max = N/5;
		
		while(max >= 0) {
			int remain = N - (max * 5);
			
			if(remain%3 == 0) {
				int answer = max + remain/3;
				System.out.println(answer);
				return;
			} 
			
			max--;
		}
		System.out.println(-1);
	}
}
