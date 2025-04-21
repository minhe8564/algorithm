/*
 * SWEA : 암호문3
 * 메모리 : 35,200kb
 * 시간 : 121ms
 */

import java.io.*;
import java.util.*;

public class SWEA_암호문3 {
	static int N;
	static List<String> list;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				list.add(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				String command = st.nextToken();
				switch(command) {
				case "I" : 
					// 삽입
					// 앞에서부터 X번째 암호문 바로 다음에 Y개의 암호문 삽입
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for(int y = 0; y < Y; y++) {
						String S = st.nextToken();
						list.add(X+y, S);
					}
					break;
				case "D" :
					// 삭제
					// 앞에서부터 X번째 암호문 바로 다음부터 Y개의 암호문 삭제
					X = Integer.parseInt(st.nextToken());
					Y = Integer.parseInt(st.nextToken());
					for(int y = 0; y < Y ; y++) {
						list.remove(X);
					}
					break;
				case "A" :
					// 추가
					// 암호문 뭉치 맨 뒤에 Y개의 암호문 추가
					Y = Integer.parseInt(st.nextToken());
					for(int y = 0; y < Y; y++) {
						String S = st.nextToken();
						list.add(S);
					}
					break;
				}
			}
			
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
