package algorithm;

import java.io.*;
import java.util.*;

public class BOJ7569_토마토2 {
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dh = new int[] { -1, 1, 0, 0, 0, 0 };
    static int[] dn = new int[] { 0, 0, 0, 0, -1, 1 };
    static int[] dm = new int[] { 0, 0, -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        Queue<int[]> q = new ArrayDeque<>();
        boolean allOk = true;

        for (int h = 0; h < H; h++) { // 높이
            for (int n = 0; n < N; n++) { // 행
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) { // 열
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        q.offer(new int[] { h, n, m });
                        visited[h][n][m] = true;
                    }
                    if (box[h][n][m] == 0) { // 익지 않은 토마토가 하나라도 있을 경우
                        allOk = false;
                    }
                }
            }
        }

        if (allOk) {
            System.out.println(0);
            return;
        }

        bfs(q);  // 모든 익은 토마토들로부터 BFS 시작

        boolean allOkAfterBfs = true;
        for (int h = 0; h < H; h++) { // 높이
            for (int n = 0; n < N; n++) { // 행
                for (int m = 0; m < M; m++) { // 열
                    if (box[h][n][m] == 0) { // 익지 않은 토마토가 하나라도 있을 경우
                        allOkAfterBfs = false;
                    }
                }
            }
        }
        
        System.out.println(allOkAfterBfs ? days : -1);
        br.close();
    }

    private static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int ch = curr[0];
                int cn = curr[1];
                int cm = curr[2];

                for (int d = 0; d < 6; d++) {
                    int nh = ch + dh[d];
                    int nn = cn + dn[d];
                    int nm = cm + dm[d];

                    if (nh >= 0 && nn >= 0 && nm >= 0 && nh < H && nn < N && nm < M && !visited[nh][nn][nm]
                            && box[nh][nn][nm] == 0) {
                        visited[nh][nn][nm] = true;
                        box[nh][nn][nm] = 1;
                        q.offer(new int[] { nh, nn, nm });
                    }
                }
            }
            if (!q.isEmpty()) {
                days++;
            }
        }
    }
}
