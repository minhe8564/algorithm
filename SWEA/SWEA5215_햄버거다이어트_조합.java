import java.io.*;
import java.util.*;

/*
 * 메모리 : 27,136kb
 * 실행시간 : 777ms
 */

public class SWEA5215_햄버거다이어트_조합 {
	static int N, L;
	static int maxScore;
	static List<int[]> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			list = new ArrayList<int[]>();
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				list.add(new int[] { score, kcal });
			}
			
			maxScore = 0;
			
//			nC0 ~ nCn
			for(int r=1; r<=N; r++) {
				comb(0, 0, 0, 0, r);
			}
			
			sb.append("#").append(t).append(" ").append(maxScore).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
	private static void comb(int cnt, int start, int score, int kcal, int r) {
		if(kcal > L) {
			return;
		}
		if(cnt == r) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		for(int n = start; n < N; n++) {
			comb(cnt+1, n+1, score+list.get(n)[0], kcal+list.get(n)[1], r);
		}
	}
	
}
