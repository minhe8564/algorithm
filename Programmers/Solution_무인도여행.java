import java.util.*;

class Solution_무인도여행 {
    static char[][] map;
    static int X, Y;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public int[] solution(String[] maps) {
        X = maps.length;
        Y = maps[0].length();
        map = new char[X][Y];
        
        for(int i = 0; i < X; i++) {
            String m = maps[i];
            for(int j = 0; j < Y; j++) {
                map[i][j] = m.charAt(j);
            }
        }
        
        visited = new boolean[X][Y];
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    int days = bfs(i, j);
                    if(days != 0) answerList.add(days);
                }
            }
        }
        
        if(answerList.isEmpty()) return new int[]{ -1 };
        
        Collections.sort(answerList);
        int answerSize = answerList.size();
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;
        
        int days = 0;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            days += map[cx][cy] - '0';
            
            for(int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 0 || ny < 0 || nx >= X || ny >= Y) continue;
                if(map[nx][ny] != 'X' && !visited[nx][ny]) {
                    q.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }
        
        return days;
    }
}
