/*
 * 레버 칸 이동 후 -> 문이 있는 칸 이동
 */
import java.util.*;

class Solution_미로찾기 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        int startX = -1, startY = -1;
        int leverX = -1, leverY = -1;
        int exitX = -1, exitY = -1;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') { // 시작
                    startX = i;
                    startY = j;
                } else if(map[i][j] == 'L') { // 레버
                    leverX = i;
                    leverY = j;
                } else if(map[i][j] == 'E') { // 출구
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        int lever = bfs(map, maps, startX, startY, leverX, leverY);
        if(lever == -1) {
            return -1;
        }
        int exit = bfs(map, maps, leverX, leverY, exitX, exitY);
        if(exit == -1) {
            return -1;
        }
        
        return lever+exit;
    }
    
    public int bfs(char[][] map, String[] maps, int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { startX, startY });
        
        int[][] time = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[startX][startY] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            if(curr[0] == endX && curr[1] == endY) { // 최소 시간
              return time[curr[0]][curr[1]];
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) continue;
                if(map[nx][ny] == 'X') continue;
                if(visited[nx][ny]) continue;
                
                q.add(new int[] { nx, ny });
                time[nx][ny] = time[curr[0]][curr[1]] + 1;
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}
