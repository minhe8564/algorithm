/*
 * SWEA 1226 : 미로1
 * 메모리 : 25,472kb
 * 시간 : 77ms
 */

import java.io.*;
import java.util.*;

public class SWEA1226_미로1 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < 10; t++){
            int tc = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ");

            map = new int[16][16];
            visited = new boolean[16][16];
            flag = false;

            for(int i = 0; i < 16; i++){
                String str = br.readLine();
                for(int j = 0; j < 16; j++){
                    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            bfs();

            sb.append(flag ? 1 : 0).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                if(map[i][j]==2){
                    q.offer(new int[] { i, j });
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            if(map[cx][cy]==3){
                flag = true;
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx >= 0 && ny >= 0 && nx < 16 && ny < 16 && !visited[nx][ny] && map[nx][ny]!=1){
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}
