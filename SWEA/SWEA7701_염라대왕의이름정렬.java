/*
 * 메모리 : 145,688kb
 * 시간 : 576ms
 * 
 * 1. 이름 길이가 짧을 수록 앞에
 * 2. 길이가 같으면 사전 순으로 앞에
 * 3. 같은 이름은 하나만 남김
 */

package algorithm;

import java.io.*;
import java.util.*;

public class SWEA7701_염라대왕의이름정렬 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			TreeSet<String> set = new TreeSet<>((o1, o2) -> {
				if(o1.length() == o2.length()) {
				    return o1.compareTo(o2);  
				} else {
				    return o1.length()-o2.length();
				}
			});
			for(int n = 0; n < N; n++) {
				String input = br.readLine();
				set.add(input);
			}

			
			sb.append("#").append(t).append("\n");
			for(String s : set) {
				sb.append(s).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
