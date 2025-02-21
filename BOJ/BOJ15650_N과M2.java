import java.io.*;
import java.util.*;

// 1~N에서 중복 없이 M개를 고른 수열
/*
 * 메모리 : 11528kb
 * 시간 : 68ms
 */

public class BOJ15650_N과M2 {
	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];

		comb(0, 1);

		System.out.println(sb);
		br.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			result[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}
