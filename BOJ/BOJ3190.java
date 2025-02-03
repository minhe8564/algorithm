package algorithm;

import java.io.*;
import java.util.*;

public class BOJ3190 {
    static int N, K, L;
    static int[][] grid;
    static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
    static int[] dy = { 1, 0, -1, 0 };
    static Map<Integer, Character> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 1; // 사과
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            snake.put(X, C);
        }
        
        Deque<int[]> d = new LinkedList<>();
        d.offer(new int[]{0, 0}); // 덱 뒤쪽 데이터 삽입, 뱀 머리 추가
        grid[0][0] = 2; // 뱀
        int time = 0;
        int dir = 0;

        while (true) {
            time++;
            int[] head = d.peekLast(); // 덱 마지막 데이터 확인
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || grid[nx][ny] == 2) {
                break;
            }

            if (grid[nx][ny] != 1) {
                int[] tail = d.poll(); // 덱 앞쪽 제거, 뱀 꼬리 삭제
                grid[tail[0]][tail[1]] = 0;
            }

            d.offer(new int[]{nx, ny}); // 덱 뒤쪽 데이터 삽입, 새로운 뱀 머리 추가
            grid[nx][ny] = 2;

            if (snake.containsKey(time)) {
                char turn = snake.get(time);
                if (turn == 'L') {
                    dir = (dir + 3) % 4;
                } else if (turn == 'D') {
                    dir = (dir + 1) % 4;
                }
            }
        }
        
        sb.append(time);
        System.out.println(sb);
        br.close();
    }
}
