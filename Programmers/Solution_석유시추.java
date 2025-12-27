import java.util.*;

class Solution_석유시추 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int N, M;
    static int[] col;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        
        // 열별 총 석유량
        col = new int[M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < col.length; i++) {
            answer = Math.max(answer, col[i]);
        }
        
        return answer;
    }
    
    // 석유 덩어리 크기 세기
    public void bfs(int n, int m, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { n, m });
        visited[n][m] = true;
        
        int size = 0;
        boolean[] sameCol = new boolean[M];
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cn = curr[0];
            int cm = curr[1];
            
            size++;
            sameCol[cm] = true;
            
            for(int d = 0; d < 4; d++) {
                int nn = cn + dx[d];
                int nm = cm + dy[d];
                
                if(nn < 0 || nm < 0 || nn >= N || nm >= M) continue;
                if(land[nn][nm] == 1 && !visited[nn][nm]) {
                    visited[nn][nm] = true;
                    q.offer(new int[] { nn, nm });
                }
            }
        }
        
        for(int i = 0; i < M; i++) {
            if(sameCol[i]) col[i] += size;
        }
    }
}
