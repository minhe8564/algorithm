package algorithm;

import java.io.*;

public class BOJ11729 {
	static StringBuilder sb = new StringBuilder();
	private static void hani(int n, int start, int temp, int end) {
		// 기조
		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		
		// 수행
		hani(n-1, start, end, temp); // start -> temp로 이동, 임시공간 end
		sb.append(start).append(" ").append(end).append("\n");
		hani(n-1, temp, start, end); // temp -> end로 이동, 임시공간 start
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println((int)Math.pow(2, N) - 1); // 2^N-1
		hani(N, 1, 2, 3);
		System.out.println(sb);
	}

}
