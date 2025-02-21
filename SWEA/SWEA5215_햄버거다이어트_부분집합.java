import java.io.*;
import java.util.*;

/*
 * 메모리 : 26,752kb
 * 실행시간 : 176ms
 */

public class SWEA5215_햄버거다이어트_부분집합.java {
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
            list = new ArrayList<>();
            
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kcal = Integer.parseInt(st.nextToken());
                list.add(new int[]{ score, kcal });
            }
            
            maxScore = 0;
            
            subset(0, 0, 0);
            
            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    
    private static void subset(int idx, int score, int kcal) {
    	if(kcal > L) {
			return;
		}
        if (idx == N) {
            maxScore = Math.max(maxScore, score);
            return;
        }
        
        subset(idx+1, score+list.get(idx)[0], kcal+list.get(idx)[1]);
        
        subset(idx+1, score, kcal);

    }
}


