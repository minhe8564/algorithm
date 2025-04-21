/*
 * SWEA : 수열편집
 * 메모리 : 27,648kb
 * 시간 : 95ms
 */

import java.io.*;
import java.util.*;

public class SWEA_수열편집 {
	static int N, M, L;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				switch(command) {
				case "I" :
					int idx = Integer.parseInt(st.nextToken());
					int add = Integer.parseInt(st.nextToken());
					list.add(idx, add);
					break;
				case "D" :
					idx = Integer.parseInt(st.nextToken());
					list.remove(idx);
					break;
				case "C" :
					idx = Integer.parseInt(st.nextToken());
					int change = Integer.parseInt(st.nextToken());
					list.set(idx, change);
				}
			}
			
			if(list.size() >= L) {
				sb.append(list.get(L)).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
