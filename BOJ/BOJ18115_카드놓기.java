/*
 * 메모리 : 16,792kb
 * 시간 : 616ms
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ18115_카드놓기 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
//		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int n = 1; n <= N; n++) {
			int command = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case 1 :
				d.offerFirst(n);
				break;
			case 2 :
				int top = d.pollFirst();
				d.offerFirst(n);
				d.offerFirst(top);
				break;
			case 3 :
				d.offerLast(n);
				break;
			}
		}
		
		for(int i : d) {
			sb.append(i).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
}
