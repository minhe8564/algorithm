import java.io.*;
import java.util.*;

// N장의 카드 중 3장 고르기
// M을 넘지 않으면서 M과 가까운 카드 3장 합 구하기
/*
 * 메모리 : 11644kb
 * 시간 : 68ms
 */

public class BOJ2798_블랙잭 {
	static int N, M;
	static int[] card;
	static int maxSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			card[n] = Integer.parseInt(st.nextToken());
		}
		
		maxSum = 0;
		comb(0, 1, 0);
		
		sb.append(maxSum);
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int cnt, int start, int sum) {
		if(cnt == 3) {
			if(sum <= M) {
				maxSum = Math.max(maxSum, sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(sum + card[i] > M) continue;
			comb(cnt+1, i+1, sum+card[i]);
		}
	}

}
