/*
 * SWEA 1873번 : 상호의 배틀필드
 * 메모리 : 28,288kb
 * 시간 : 187ms
 */

import java.io.*;
import java.util.*;
 
public class SWEA1873_상호의배틀필드 {
    static int H, W;
    static char[][] map;
    static int N;
    static String[] command;
    static int dir, tankX, tankY;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int h = 0; h < H; h++) {
                String str = br.readLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = str.charAt(w);
                    switch(map[h][w]) {
                    case '^' : 
                        dir = 0;
                        tankX = h;
                        tankY = w;
                        break;
                    case 'v' : 
                        dir = 1;
                        tankX = h;
                        tankY = w;
                        break;
                    case '<' : 
                        dir = 2;
                        tankX = h;
                        tankY = w;
                        break;
                    case '>' : 
                        dir = 3;
                        tankX = h;
                        tankY = w;
                    }
                }
            }
            N = Integer.parseInt(br.readLine());
            command = new String[N];
            command = br.readLine().split("");
            for(int n = 0; n < N; n++) {
                movement(command[n]);
            }
 
            sb.append("#").append(t).append(" ");
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    sb.append(map[h][w]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
 
    private static void movement(String cmd) {
        switch (cmd) {
            case "U": 
                dir = 0; 
                move(); 
                break;
            case "D": 
                dir = 1; 
                move(); 
                break;
            case "L": 
                dir = 2; 
                move(); 
                break;
            case "R": 
                dir = 3; 
                move(); 
                break;
            case "S": 
                shoot(); 
                break;
        }
    }
 
    private static void move() {
        int nx = tankX + dx[dir];
        int ny = tankY + dy[dir];
 
        // 탱크 방향 변경
        char[] tankDir = {'^', 'v', '<', '>'}; // 상, 하, 좌, 우
        map[tankX][tankY] = tankDir[dir];
 
        if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
            map[nx][ny] = map[tankX][tankY]; // 탱크 이동
            map[tankX][tankY] = '.'; // 탱크 평지로 변경
            tankX = nx;
            tankY = ny;
        }
    }
 
    private static void shoot() {
        int sx = tankX;
        int sy = tankY;
 
        while (true) {
            sx += dx[dir];
            sy += dy[dir];
 
            // 강철벽 만나면 종료
            if (sx < 0 || sy < 0 || sx >= H || sy >= W || map[sx][sy] == '#') {
                return; 
            }
 
            // 벽돌벽 만나면 평지로
            if (map[sx][sy] == '*') { 
                map[sx][sy] = '.';
                return;
            }
        }
    }
}
