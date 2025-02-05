package algorithm;

import java.io.*;
import java.util.*;

public class BOJ13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long count = 0;
		for (int n = 0; n < N; n++) {
			count++;
			A[n] -= B;
			
			if(A[n] > 0) {
				int subCount = A[n] / C;
				if(A[n] % C != 0) {
					subCount++;
				}
				count += subCount;
			}
		}

		System.out.println(count);
		br.close();
	}
}
