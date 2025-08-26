/*
 * BOJ 11404번 : 플로이드
 * 메모리 : 41,976kb
 * 시간 : 348ms
 */

import java.io.*;
import java.util.*;

public class BOJ11404_플로이드 {
    static int N, M;
    static int[][] dist;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        for(int n = 1; n <= N; n++) {
            Arrays.fill(dist[n], INF);
            dist[n][n] = 0;
        }

        for(int m = 1; m <= M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int n = 1; n <= N; n++) { // 거치는 정점
            for(int a = 1; a <= N; a++) { // 출발
                for(int b = 1; b <= N; b++) { // 도착
                    if(dist[a][b] > dist[a][n]+dist[n][b]) {
                        dist[a][b] = dist[a][n]+dist[n][b];
                    }
                }
            }
        }

        for(int a = 1; a <= N; a++) {
            for(int b = 1; b <= N; b++) {
                sb.append(dist[a][b] == INF ? 0 : dist[a][b]);
                if(b < N) sb.append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
