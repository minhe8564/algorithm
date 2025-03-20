/*
 * BOJ 2877번 : 4와 7
 * 메모리 : 11,480번
 * 시간 : 64ms
 * 
 * K가 홀수라면 맨뒤 4
 * 앞에 K/2번째 수 
 */

import java.io.*;
import java.util.*;

public class BOJ2877_4와7 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		while (N > 0) {
			int M = N%2;
			N /= 2;
			if(M != 0) {
				sb.insert(0, 4);
			} else {
				N--;
				sb.insert(0, 7);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
