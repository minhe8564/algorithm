import java.io.*;
import java.util.*;

public class BOJ6593_상범빌딩 {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0, 0, 0}; 
    static int[] dy = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break; 

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int startL = 0, startR = 0, startC = 0;
            int endL = 0, endR = 0, endC = 0;

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String str = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = str.charAt(c);
                        if (map[l][r][c] == 'S') { 
                            startL = l;
                            startR = r;
                            startC = c;
                        } else if (map[l][r][c] == 'E') { 
                            endL = l;
                            endR = r;
                            endC = c;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(startL, startR, startC, endL, endR, endC);
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static int bfs(int l, int r, int c, int endL, int endR, int endC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{l, r, c, 0}); 
        visited[l][r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cl = curr[0]; 
            int cr = curr[1];
            int cc = curr[2];
            int time = curr[3];

            if (cl == endL && cr == endR && cc == endC) return time; 

            for (int d = 0; d < 6; d++) {
                int nl = cl + dz[d], nr = cr + dx[d], nc = cc + dy[d];

                if (nl >= 0 && nr >= 0 && nc >= 0 && nl < L && nr < R && nc < C && !visited[nl][nr][nc] && map[nl][nr][nc] != '#') {
                    visited[nl][nr][nc] = true;
                    q.offer(new int[]{nl, nr, nc, time+1});
                }
            }
        }
        return -1;
    }
}
