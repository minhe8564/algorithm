package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        int num = 1;
        int X = N / 2;
        int Y = N / 2;
        arr[X][Y] = num;
        int stage = 1;

        while (stage < N) {
            // 왼쪽 이동 (1칸)
            Y--;
            num++;
            arr[X][Y] = num;

            // 아래 이동 (stage 칸)
            for (int j = 0; j < stage; j++) {
                X++;
                num++;
                arr[X][Y] = num;
            }

            // 오른쪽 이동 (stage+1 칸)
            for (int j = 0; j < stage + 1; j++) {
                Y++;
                num++;
                arr[X][Y] = num;
            }

            // 위로 이동 (stage+1 칸)
            for (int j = 0; j < stage + 1; j++) {
                X--;
                num++;
                arr[X][Y] = num;
            }

            // 왼쪽 이동 (stage+1 칸)
            for (int j = 0; j < stage + 1; j++) {
                Y--;
                num++;
                if (num > N * N) break;  // 배열이 다 채워졌으면 종료
                arr[X][Y] = num;
            }

            stage += 2;
        }

        // 숫자 1을 놓치지 않도록 처리
        if (N > 1) {
            for (int i = 0; i < N - 1; i++) {
                X++;
                num++;
                arr[X][Y] = num;
            }
        }

        // 찾는 숫자의 위치 저장
        int x = 0, y = 0;
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
