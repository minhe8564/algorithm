package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656_N과M7 {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		result = new int[M];

		perm(0);

		System.out.println(sb);
		br.close();
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			result[cnt] = arr[i];
			perm(cnt + 1);
		}
	}

}
