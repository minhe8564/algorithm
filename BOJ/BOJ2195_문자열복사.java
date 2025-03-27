/*
 * BOJ 2195번 : 문자열 복사
 * 메모리 : 12,816kb
 * 시간 :84ms
 * 
 * P에서 S로 간다고 생각!
 * P의 일부분이 S에 있으면 cnt++
 * 최대한 길게 끊어야 최소로 사용할 수 있다
 * 
 * 1. S에 포함되는지 판단
 * 2. 문자열이 S에 포함안될 때까지 이어붙인다.
 * 3. 포함 안되면 -> cnt++, idx를 거기서부터 새로운 문자열 
 */

import java.io.*;
import java.util.*;

public class BOJ2195_문자열복사 {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		String P = br.readLine();
		
		cnt = 0;
		int idx = 0;
		while(idx < P.length()) {
			String copy = "";
			
			if(S.contains(P.substring(idx))) {
				cnt++;
				break;
			}
			
			for(int i = idx; i < P.length(); i++) {
				copy += P.charAt(i);
				
				if(!S.contains(copy)) {
					cnt++;
					idx = i; // 포함 안되는 곳부터 다시 검사
					break;
				}
			}
		}
		
		sb.append(cnt);
		System.out.print(sb);
		br.close();
	}
}
