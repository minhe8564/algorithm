package algorithm;

import java.io.*;
import java.util.*;

public class BOJ10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		// 누적 합의 나머지 개수 세기
		long sum = 0;
		long[] prefixMod  = new long[M]; // 나머지 저장
		
		for(int n = 0; n < N; n++) {
			sum += Integer.parseInt(st.nextToken());
			int mod = (int)(sum % M);
			prefixMod[mod]++;
		}
		
		// 나머지가 0인 경우
		long count = 0;
		count += prefixMod[0];
		
		// 나머지가 같은 값끼리 조합해서 개수 세기 (누적합 개수 중 2가지 고르기) (nC2 = n(n-1)/2)
		for(int i = 0; i < M; i++) {
			if(prefixMod[i] > 1) {
				count += (prefixMod[i] * (prefixMod[i]-1))/2;
			}
		}
		
		System.out.println(count);
		br.close();
	}

}
