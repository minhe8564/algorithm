package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++) {
			temp[n] = Integer.parseInt(st.nextToken());
		}
		
		// 수열, 슬라이딩 윈도우
		// 처음 K개의 원소 합
		int currentSum = 0;
		for(int k = 0; k < K; k++) {
			currentSum += temp[k];
		}
		
		int maxSum = currentSum;
		for(int i = K; i < N; i++) {
			// 기존 합에서 윈도우 첫번째 값 빼고, 새로 포함된 값 더함
			currentSum = currentSum - temp[i-K] + temp[i];
			maxSum = Math.max(maxSum, currentSum);
		}
		
		System.out.println(maxSum);
		br.close();
	}

}
