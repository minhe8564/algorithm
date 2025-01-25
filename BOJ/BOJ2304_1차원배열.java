package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2304_1차원배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 기둥의 개수
        int[] heights = new int[1001]; // 최대 x 위치가 1000이므로 크기를 1001로 설정
        int maxX = 0; // x 좌표의 최대값

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); // x 좌표
            int h = Integer.parseInt(st.nextToken()); // 높이
            heights[x] = h; // x 좌표에 해당하는 높이를 저장
            maxX = Math.max(maxX, x); // 최대 x 값을 갱신
        }

        // 1. 최고 높이 찾기
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i <= maxX; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIndex = i;
            }
        }

        int area = 0;

        // 2. 왼쪽부터 최고 높이까지 면적 계산
        int leftMax = 0;
        for (int i = 0; i <= maxIndex; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            area += leftMax;
        }

        // 3. 오른쪽부터 최고 높이까지 면적 계산
        int rightMax = 0;
        for (int i = maxX; i > maxIndex; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            area += rightMax;
        }

        System.out.println(area);
        br.close();
    }
}
