class Solution_이웃한칸 {
    static int N;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N];
        visited[h][w] = true;
        
        for(int d = 0; d < 4; d++) {
            int nx = h + dx[d];
            int ny = w + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny]) continue;
            
            if(board[h][w].equals(board[nx][ny])) {
                visited[nx][ny] = true;
                answer++;
            }
        }
        
        return answer;
    }
}
