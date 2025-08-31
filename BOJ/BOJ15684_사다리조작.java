/* 
 * BOJ 15684번 : 사다리 조작
 * 메모리 : 15,036kb
 * 시간 : 504ms
 */

import java.io.*;
import java.util.*;

public class BOJ15684_사다리조작 {
    static int N, M, H;
    static boolean[][] ladder;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 가로선
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 개수
        ladder = new boolean[H+1][N+1];
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 행
            int b = Integer.parseInt(st.nextToken()); // 왼쪽 세로선
            ladder[a][b] = true; // 이미 놓인 가로선 체크
        }

        result = Integer.MAX_VALUE;

        // 3개까지 추가 시도
        for(int i = 0; i <= 3; i++) {
            dfs(0, i, 1, 1); // depth, limit, startRow, startCol
        }

        if(result > 3 || result == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(result);
        }
        System.out.println(sb);
        br.close();
    }

    // dfs로 가로선 추가
    public static void dfs(int depth, int limit, int startRow, int startCol) {
        if(check()) {
            result = Math.min(result, depth);
            return;
        }

        if(depth == limit) {
            return;
        }

       for(int r = startRow; r <= H; r++) {
           int searchCol = (r==startRow ? startCol : 1);
           for(int c = searchCol; c < N; c++) {
               if(canLink(r, c)) {
                   ladder[r][c] = true;
                   dfs(depth+1, limit, r, c+2); // 같은 행에서는 인접 불가 -> c+2 부터
                   ladder[r][c] = false;
               }
           }
       }
    }

    // 모든 세로선이 자기자신으로 끝나는지 확인
    public static boolean check() {
        for(int n = 1; n <= N; n++) {
            int pos = n;
            for(int h = 1; h <= H; h++) {
                if(ladder[h][pos]) {
                    pos++;
                } else if (pos > 1 && ladder[h][pos-1]) {
                    pos--;
                }
            }
            if(pos != n) {
                return false;
            }
        }
        return true;
    }

    // 같은 행 겹치거나 인접하면 배치 불가능
    public static boolean canLink(int r, int c) {
       if(ladder[r][c]) {
           return false;
       }
       if(c > 1 && ladder[r][c-1]) {
           return false;
       }
       if(c < N-1 && ladder[r][c+1]) {
           return false;
       }
       return true;
    }
}
