/*
 * 메모리 : 16,964kb
 * 시간 : 136ms
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1863_스카이라인쉬운거 {
	static int N;
	static int minCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		minCnt = 0;
		Stack<Integer> s = new Stack<Integer>();
		for(int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty()) {
				int top = s.peek();
				if(top > y) {
					minCnt++;
					s.pop();
				} else if(top == y) {
					break;
				} else {
					s.push(y);
					break;
				}
			}
			
			if(s.isEmpty()) {
				s.push(y);
			}
		}
		
		while(!s.isEmpty() && s.peek() > 0) {
			minCnt++;
			s.pop();
		}
		
		sb.append(minCnt);
		System.out.print(sb);
		br.close();
	}
}
