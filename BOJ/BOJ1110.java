package algorithm;

import java.io.*;

public class BOJ1110 {

	public static void main(String[] args) throws IOException {
		// 10보다 작으면 앞에 0 붙이기 -> 각 자리의 숫자 더하기
		// 주어진 수 오른쪽 수 + 합의 오른쪽 수 -> 새로운 수
		// N이 원래의 수로 돌아오는 사이클
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int x = N;
		int count = 0;
		
		while(true) {
			int i = x / 10;
			int j = x % 10;
			
			int sum = i+j;
			
			x = j*10 + sum%10;
			count++;
			
			if(x == N) {
				break;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		
		
	}

}
