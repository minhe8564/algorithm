/*
 * BOJ 15653번 : 구슬탈출4
 * 메모리 : 11,712kb
 * 시간 : 72ms
 * 
 * 한 방향으로 끝까지 굴리기
 * 파란 구슬이 구명에 빠지면 실패 (그 상태 버림)
 * 빨간 구슬만 구멍에 빠지면 성공 (이때 이동 횟수가 정답)
 * 둘 다 구멍이 아니고 같은 칸에 멈추면 더 많이 굴러온 쪽을 한 칸 뒤로 빼서 겹침 해소
 */

import java.io.*;
import java.util.*;

public class BOJ15653_구슬탈출4 {
    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class State {
        int rx, ry, bx, by, dist;
        State(int rx, int ry, int bx, int by, int dist) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int rx = -1, ry = -1;
        int bx = -1, by = -1;

        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            for(int m = 0; m < M; m++) {
                board[n][m] = line.charAt(m);
                if(line.charAt(m) == 'R') {
                    rx = n;
                    ry = m;
                    board[n][m] = '.';
                }
                if(line.charAt(m) == 'B') {
                    bx = n;
                    by = m;
                    board[n][m] = '.';
                }
            }
        }

        sb.append(bfs(rx, ry, bx, by));
        System.out.println(sb);
        br.readLine();
    }

    // 최소 기울이기 횟수 탐색
    static int bfs(int rx, int ry, int bx, int by) {
        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<State> q = new ArrayDeque<>();
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()) {
            State curr = q.poll();

            for(int d = 0; d < 4; d++) {
                RollResult r = roll(curr.rx, curr.ry, d);
                RollResult b = roll(curr.bx, curr.by, d);

                // 파란 구슬 빠지면 실패
                if(b.isHole) {
                    continue;
                }

                // 빨간 구슬 빠지면 성공
                if(r.isHole) {
                    return curr.dist+1;
                }

                // 같은 칸에 멈추면 더 많이 굴러온 구슬 한 칸 뒤로 빼기
                if(r.x == b.x && r.y == b.y) {
                    if(r.steps > b.steps) {
                        r.x -= dx[d];
                        r.y -= dy[d];
                    } else {
                        b.x -= dx[d];
                        b.y -= dy[d];
                    }
                }

                if(!visited[r.x][r.y][b.x][b.y]) {
                    visited[r.x][r.y][b.x][b.y] = true;
                    q.add(new State(r.x, r.y, b.x, b.y, curr.dist + 1));
                }
            }
        }
        return -1;
    }

    static RollResult roll(int x, int y, int d) {
        int move = 0;

        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(board[nx][ny] == '#') { // 벽
                break;
            }

            x = nx;
            y = ny;
            move++;

            if(board[nx][ny] == 'O') { // 구멍이면 바로 종료
                return new RollResult(x, y, move, true);
            }
        }

        return new RollResult(x, y, move, false);
    }

    static class RollResult {
        int x, y;
        int steps;
        boolean isHole;
        RollResult(int x, int y, int steps, boolean isHole) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.isHole = isHole;
        }
    }
}
