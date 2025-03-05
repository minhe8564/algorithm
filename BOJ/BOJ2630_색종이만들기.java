import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int whiteArea, blueArea;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		whiteArea = 0; blueArea = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		mapCheck(0, 0, N);
		
		sb.append(whiteArea).append("\n").append(blueArea);
		System.out.println(sb);
		br.close();
	}

	private static void mapCheck(int x, int y, int N) {
		boolean white = true;
		boolean blue = true;
		for(int i = x; i < x+N; i++) {
			for(int j = y; j < y+N; j++) {
				if(map[i][j]==1) white = false;
				else blue = false;
			}
		}
		
		if(white) {
			whiteArea++;
			return;
		}
		if(blue) {
			blueArea++;
			return;
		}
		
		mapCheck(x, y, N/2); // 왼쪽 위
		mapCheck(x, y+N/2, N/2); // 오른쪽 위
		mapCheck(x+N/2, y, N/2); // 왼쪽 아래
		mapCheck(x+N/2, y+N/2, N/2); // 오른쪽 아래
		
	}

}
