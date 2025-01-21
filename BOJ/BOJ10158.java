package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		if(((p + t) / w) % 2 == 0) { // 짝수 : 원래 방향으로 진행
			sb.append((p + t) % w);			
		}
		else { // 홀수 : 반대 방향으로 진행, 좌표 계산 반대로
			sb.append(w - (p + t) % w);
		}
		sb.append(" ");
		
		if(((q + t) / h) % 2 == 0) {
			sb.append((q + t) % h);
		}
		else {
			sb.append(h - (q + t) % h);
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
