package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1913_달팽이 {
	static int[] dx = { -1, 0, 1, 0 }; // 상1우1하2좌2상3우3하4좌4상5
	static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int num = 1;
        int x = N/2;
        int y = N/2;
        arr[x][y] = num++;
        
        int dir = 0;
        int steps = 1;

        while(num <= N*N) {
        	for(int i = 0; i < steps; i++) {
        		x += dx[dir];
        		y += dy[dir];
        		
        		if(x >= 0 && y >= 0 && x < N && y < N) {
        			arr[x][y] = num++;
        		}
        	}
        	
        	dir = (dir+1) % 4;
        	
        	if(dir==0 || dir==2) {
        		steps++;
        	}
        }

        // 찾는 숫자의 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == find) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }

        sb.append(x).append(" ").append(y);
        System.out.println(sb);
        br.close();
    }
}
