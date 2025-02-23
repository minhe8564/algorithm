package algorithm;

import java.io.*;
import java.util.*;

public class BOJ30802_웰컴키트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 참가자 수
		int[] tee = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++) {
			tee[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 티셔츠 묶음 수
		int P = Integer.parseInt(st.nextToken()); // 펜 묶음 수
		
		int teeCnt = 0;
		for (int i = 0; i < 6; i++) {
			if(tee[i] <= T && tee[i] != 0) {
				teeCnt++;
			} else{
//				teeCnt += (int) Math.round((double)tee[i]/T); // Math.round(5.0/2) = Math.round(2.5) = 2 반올림 오류!!
				teeCnt += (int) Math.ceil((double)tee[i]/T);
			}
		}
		sb.append(teeCnt).append("\n");
		sb.append(N/P).append(" ").append(N%P);
		
		System.out.println(sb);
		br.close();
	}

}
