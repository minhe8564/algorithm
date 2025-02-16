package algorithm;

import java.io.*;
import java.util.*;

public class SWEA1767_프로세서연결하기 {
	static int N;
	static int[][] cell;
	static List<Core> cores;
	static int maxCore, minLength;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cell = new int[N][N];
			cores = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리에 위치한 코어는 이미 전원이 연결된 것
					if (cell[i][j] == 1 && i > 0 && j > 0 && i < N-1 && j < N-1) {
						cores.add(new Core ( i, j ));
					}
				}
			}
			
			// 조건
			// 1. core와 전원을 연결하는 전선은 직선으로만 설치 가능 (상하좌우 중 하나의 선으로만)
			// 2. 전선은 교차 불가능

			// 풀이
			// 1. dfs로 코어 연결 조합 탐색
			// 2. 각 코어마다 상하좌우 방향으로 전선을 연결할 수 있는지 체크
			// 3. 최대한 많은 코어를 연결한 경우 중 전선 길이가 최소인 경우 갱신

			maxCore = 0;
			minLength = Integer.MAX_VALUE;

			setCore(0, 0, 0);

			sb.append("#").append(t).append(" ").append(minLength).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	// 코어 연결 조합 탐색 dfs
	private static void setCore(int idx, int coreCount, int wireLength) {
		if (idx == cores.size()) {
			if (coreCount > maxCore) {
				maxCore = coreCount;
				minLength = wireLength;
			} else if (coreCount == maxCore) {
				minLength = Math.min(minLength, wireLength);
			}
			return;
		}

		Core core = cores.get(idx);
		
		// 코어를 연결하지 않는 경우
		setCore(idx + 1, coreCount, wireLength);

		for (int d = 0; d < 4; d++) {
			int length = getLength(core, d);

			if (length > 0) {
				setLine(core, d, length, 2); // 현재 방향으로 length 길이만큼 전선 설치
				setCore(idx + 1, coreCount + 1, wireLength + length);
				setLine(core, d, length, 0); // 다음 방향 시도를 위해 전선 제거
			}
		}
	}

	// 코어 기준 해당 방향으로 length 만큼의 체크 (value 2(설치), 0(미설치)
	private static void setLine(Core core, int d, int length, int value) {
		int x = core.x;
		int y = core.y;

		for(int i = 0; i < length; i++) {
			x += dx[d];
			y += dy[d];
			cell[x][y] = value;
		}
	}

	// 코어를 d 방향으로 설치했을 때 전선길이 반환, 설치불가하면 0 반환
	private static int getLength(Core core, int d) {
		int x = core.x;
		int y = core.y;
		int length = 0;
		
		while(true) {
			x += dx[d];
			y += dy[d];
			
			// 경계를 벗어나는 경우, 설치 가능, 현재까지의 길이 반환
			if(x < 0 || x >= N || y < 0 || y >= N) {
				return length;
			}
			
			// 0이 아닌 경우 (전선, 코어) 설치 불가능
			if(cell[x][y] != 0) {
				return 0;
			}
			
			// 0인 경우 설치길이 증가
			length++;
		}
		
	}
}
