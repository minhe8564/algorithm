package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1952 {
	static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int idx = 0;
        int cnt = 0;
        int sum = 0;
        int x = 0;
        int y = 0;
        boolean visited[][] = new boolean[M][N];
        
        visited[x][y] = true;
        sum = 1;
        
        // 우, 하, 좌, 상 반복
        while(idx < 4) {
        	// 기저 : 전체를 다 방문했을 경우 종료
        	if(sum == M*N) {
        		System.out.println(cnt);
        		return;
        	}
        	
        	// 우, 하, 좌, 상 이동
        	int nx = x + dx[idx];
        	int ny = y + dy[idx];
        	
        	// 범위 안에 있고 아직 방문하지 않았을 경우
        	if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
        		sum++;
        		visited[nx][ny] = true;
        		
        		// 갱신된 위치를 현재 위치에 반영해 우, 하, 좌, 상 끝까지 방문할 수 있도록
        		x = nx;
        		y = ny;
        	}
        	else {
        		// 범위 안에 없을 경우, 다음 방향으로
        		idx++;
        		cnt++;
        	}
        	
        	// 우, 하, 좌, 상 다 돌았을 경우 다시 처음윽로
        	if(idx >= 4) {
        		idx = 0;
        	}
        }
        
        br.close();
	}

}
