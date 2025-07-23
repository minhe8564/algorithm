/*
 * BOJ 16974번 : 레벨 햄버거
 * 메모리 : 11,548kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ16974_레벨햄버거 {
    static int N;
    static long X;
    static long[] hamburger;
    static long[] patty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        hamburger = new long[N+1];
        patty = new long[N+1];

        hamburger[0] = 1;
        patty[0] = 1;

        for(int n = 1; n <= N; n++) {
            hamburger[n] = 1 + hamburger[n-1] + 1 + hamburger[n-1] + 1;
            patty[n] = patty[n-1] + 1 + patty[n-1];
        }

        sb.append(levelHamBurger(N, X));
        System.out.println(sb);
        br.close();
    }

    public static long levelHamBurger(int level, long count) {
        if(level == 0) {
            if(count == 0) {
                return 0;
            } else if(count == 1) {
                return 1;
            }
        }

        // 첫 시작은 빵
        if(count == 1) { 
            return 0;
        }

        // 이전 햄버거 + 1 (햄버거 번호가 왼쪽 햄버거 범위)
        else if(count <= hamburger[level-1] + 1) {
            return levelHamBurger(level-1, count-1);
        }

        // 1 + 이전 햄버거 + 1 (햄버거랑 패티 위치 같을 때)
        else if(count == 1 + hamburger[level-1] + 1) { 
            return patty[level-1] + 1;
        }

        // 1 + 이전 햄버거 + 1 + 이전 햄버거 (햄버거가 오른쪽 햄버거 범위)
        else if(count <= 1 + hamburger[level-1] + 1 + hamburger[level-1]) {
            return patty[level-1] + 1 + levelHamBurger(level-1, count - (1 + hamburger[level-1] + 1));
        }

        // 햄버거 번호가 햄버거 레벨 전체 범위일 경우
        else {
            return patty[level-1] + 1 + patty[level-1];
        }
    }
}
