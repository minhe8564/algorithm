package algorithm;

import java.io.*;
import java.util.*;

public class BOJ25305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N ; n++) {
			score[n] = Integer.parseInt(st.nextToken());
		}
		
		// N명 중 가장 높은 k명 상 받음
		// 상을 받는 사람들 중 가장 점수가 낮은 사람?
		Arrays.sort(score);
		int[] getScore = Arrays.copyOfRange(score, N-K, N);
		
		System.out.println(getScore[0]);
		br.close();
	}

}
