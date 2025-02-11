package algorithm;

import java.io.*;
import java.util.*;

public class SWEA5660_핀볼게임 {
    static int N, max;
    static int[][] board;
    static int[][] wormhole = new int[11][4]; // 웜홀 정보 저장
    static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(sc.nextLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(sc.nextLine().trim());
            board = new int[N][N];
         홀 초기화
            for (int i = 6; i <= 10; i++) {
                Arrays.fill(wormhole[i], -1);
            }
            
            // 시작점 저장
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            	String[] st = sc.nextLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st[j]);
                    if (board[i][j] == 0) {
                        list.add(new int[]{i, j}); // 빈칸인 경우 시작점 리스트에 추가
                    } 
                    else if (board[i][j] >= 6) {
                        int w = board[i][j];
                        if (wormhole[w][0] == -1) {
                            wormhole[w][0] = i;
                            wormhole[w][1] = j;
                        } else {
                            wormhole[w][2] = i;
                            wormhole[w][3] = j;
                        }
                    }
                }
            }
            
            int maxScore = 0;
            // 모든 점의 4방향에 대해 게임 실행
            for (int[] start : list) {
                for (int d = 0; d < 4; d++) {
                    maxScore = Math.max(maxScore, play(start[0], start[1], d));
                }
            }
            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
//        br.close();
        sc.close();
    }

    static int play(int x, int y, int dir) {
        int score = 0;
        int startX = x, startY = y;
        int currentDir = dir;

        while (true) {
            x += dx[currentDir];
            y += dy[currentDir];
            
            // 1. 벽 충돌
            if (x < 0 || y < 0 || x >= N || y >= N) {
                currentDir = (currentDir + 2) % 4;
                score++;
                continue;
            }
            
            int num = board[x][y];
            // 2. 블랙홀, 시작점 다시 도착
            if (num == -1 || (x == startX && y == startY)) break;
            
            // 3. 블럭 충돌
            if (1 <= num && num <= 5) {
                currentDir = changeDir(num, currentDir);
                score++;
            }
            // 4. 웜홀 
            else if (6 <= num && num <= 10) {
                if (wormhole[num][0] == x && wormhole[num][1] == y) {
                    x = wormhole[num][2];
                    y = wormhole[num][3];
                } else {
                    x = wormhole[num][0];
                    y = wormhole[num][1];
                }
            }
        }
        return score;
    }

    static int changeDir(int wall, int dir) {
    	// 기본적으로 반대 방향으로 전환
    	int ndir = (dir + 2) % 4;
        switch (wall) {
            case 1:
                if (dir == 1) ndir = 0;
                if (dir == 2) ndir = 3;
                break;
            case 2:
                if (dir == 2) ndir = 1;
                if (dir == 3) ndir = 0;
                break;
            case 3:
                if (dir == 0) ndir = 1;
                if (dir == 3) ndir = 2;
                break;
            case 4:
                if (dir == 1) ndir = 2;
                if (dir == 0) ndir = 3;
                break;
            case 5:
                ndir = (dir + 2) % 4;
                break;
        }
        return ndir;
    }
}
