package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15657_N과M9 {
	static int N, M;
	static int[] input;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		perm(0);

		System.out.println(sb);
		br.close();
	}

	// 중복되는 순열 제거
	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = 0; // 중복 체크를 위한 변수
		for (int i = 0; i < N; i++) {
			if (visited[i] || input[i] == before)
				continue; // 바로 다음 i로 이동
			
				visited[i] = true;
				result[cnt] = input[i];
				before = input[i]; // 중복 방지용 변수 업데이트
				perm(cnt + 1);
				visited[i] = false;
		}
	}

}
