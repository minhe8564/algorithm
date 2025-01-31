package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			card[n] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int i = 0; i < (N - 2); i++) {
			for(int j = (i + 1); j < (N - 1); j++) {
				for(int k = (j + 1); k < N; k++) {
					int max = card[i] + card[j] + card[k];
					if(max <= M) {
						answer = Math.max(answer, max);
					}
				}
			}
		}

		sb.append(answer);
		System.out.println(sb);
		br.close();

	}

}
