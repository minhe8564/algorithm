/*
 * SWEA : 이진수 표현
 * 메모리 : 32,640kb
 * 시간 : 128ms
 * 
 * 정수 M의 마지막 N개의 비트가 모두 1인지 확인
 */

import java.io.*;
import java.util.*;

public class SWEA_이진수표현 {
	static int N, M;
	static boolean isON;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isON = true;
			
//			String M_bit = Integer.toBinaryString(M);
//			System.out.println(M_bit);
			
//			for(int i = 0; i < N; i++) {
//				if(M%2==0) isON=false;
//				M /= 2;
//			}
			
			// 1을 i번 왼쪽으로 shift
			// M & (1<<i) i번째 비트가 1이면 결과는 0이 아님
			for(int i = 0; i < N; i++) {
				if((M & (1<<i)) == 0) isON=false;
			}
			
			sb.append(isON ? "ON" : "OFF").append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
