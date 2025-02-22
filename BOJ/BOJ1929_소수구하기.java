package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i*i <= N; i++) { // i*i가 int 범위를 초과할 수 있음
			if(isPrime[i]) {
				for(int j = i*i; j <= N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(isPrime[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
