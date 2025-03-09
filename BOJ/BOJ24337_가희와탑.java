/*
 * 메모리 : 22,076kb
 * 시간 : 488ms
 */

import java.io.*;
import java.util.*;

public class BOJ24337_가희와탑 {
	static int N, A, B;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();
		
		for(int i = 1; i < A; i++) {
			list.add(i);
		}
		list.add(Math.max(A, B));
		for(int i = B-1; i >= 1; i--) {
			list.add(i);
		}
		
		// 조건 1
		if(list.size() > N) {
			System.out.print(-1);
			return;
		}
		
		// 조건 2
		while(list.size() < N) {
			if(A == 1) {
				list.add(1, 1);
			} else {
				list.add(0, 1);
			}
		}
		
		for(int i : list) {
			sb.append(i).append(" ");
		}
		
		System.out.print(sb);
		br.close();
	}
}
