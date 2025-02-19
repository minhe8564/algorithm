import java.io.*;
import java.util.*;

public class Solution1210_Ladder1 {
    static int[][] map;
    static int[] dx = { 0, 0, 1 }; // 좌, 우, 상
    static int[] dy = { -1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            map = new int[100][100];

            int startX = 0, startY = 0;
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            int result = find(startX, startY);
            sb.append("#").append(T).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int find(int x, int y) {
        boolean[][] visited = new boolean[100][100];

        while (x > 0) {
            visited[x][y] = true;
            
            if (y > 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) { // 좌
                y--;
            } else if (y < 99 && map[x][y + 1] == 1 && !visited[x][y + 1]) { // 우
                y++;
            } else { // 상
                x--;
            }
        }
        return y;
    }
}
