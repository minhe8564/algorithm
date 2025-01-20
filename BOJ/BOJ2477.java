package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int K = Integer.parseInt(br.readLine()); // 참외의 개수
        
        int[] dir = new int[6]; // 방향 (1:동쪽, 2:서쪽, 3:남쪽, 4:북쪽)
        int[] length = new int[6]; // 길이
        for (int i = 0; i < 6; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	dir[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }
        
        // 1. 큰 직사각형의 면적
        int width = 0, height = 0;
        int widthIdx = -1, heightIdx = -1;

        for (int i = 0; i < 6; i++) {
            if (dir[i] == 1 || dir[i] == 2) { // 가로
                if (width < length[i]) {
                	width = length[i];
                    widthIdx = i;
                }
            }
            if (dir[i] == 3 || dir[i] == 4) { // 세로
                if (height < length[i]) {
                	height = length[i];
                	heightIdx = i;
                }
            }
        }
        int maxArea = width*height;

        // 2. 작은 직사각형의 면적
        // 반대편 가로와 세로의 길이
        int minArea = length[(widthIdx + 3) % 6] * length[(heightIdx + 3) % 6];

        // 참외밭 면적 계산
        int area = maxArea - minArea;
        System.out.println(area*K);
    }
}
