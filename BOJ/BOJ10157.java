package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {
	static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dy = {0, 1, 0, -1};
	static int[][] grid;
	static boolean[][] vistied;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		// System.out.println(Arrays.deepToString(grid));
		// 1. 첫 번째 사람, 대기번호 1번, (1,1) 배정
		// 2. 위쪽으로 이동 -> 오른쪽으로 이동 -> 아래쪽으로 이동 -> 왼쪽으로 이동 (시계방향)
		// 대기번호 K 인 관객에게 배정될 좌석 번호 출력 (x, y)?
		// 모든 좌석 배정된 경우 0 출력
		
		if (K > C*R) {
            System.out.println(0);
            return;
        }

        boolean[][] visit = new boolean[R][C];

        int count = 0, x = R - 1, y = 0, dir = 0;
        while (++count != K) {
            visit[x][y] = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny]) {
                dir = ++dir % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        sb.append(y+1).append(" ").append(R-x);
		System.out.println(sb);
	}

}
