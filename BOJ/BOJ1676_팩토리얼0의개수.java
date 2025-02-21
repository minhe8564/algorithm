package algorithm;

import java.io.*;
import java.util.*;

// 0이 나오는 경우 -> 2, 5가 곱해져 있을 때
// (2, 5) 쌍의 개수 -> 0의 개수
// 5로 나누었을 때 수 -> 0의 개수

public class BOJ1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N  = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(N >= 5) {
			cnt += N/5;
			N /= 5;
		}
		
		sb.append(cnt);
		System.out.println(sb);
		br.close();
	}
	

}
