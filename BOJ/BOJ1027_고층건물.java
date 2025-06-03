/*
 * BOJ 1027번 : 고층건물
 * 메모리 : 11,772kb
 * 시간 : 76ms
 */

import java.io.*;
import java.util.*;

public class BOJ1027_고층건물 {
    static int N;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            buildings[n] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        // 모든 건물을 기준으로 보이는 건물 수 계산
        for(int i = 0; i < N; i++) {
            int visible = 0;

            // 왼쪽 탐색
            double maxSlopeLeft = Double.MIN_VALUE;
            for(int j = i-1; j >= 0; j--) {
                // i 기준에서 왼쪽 j 건물까지의 기울기 계산
                double slope = (double)(buildings[i]-buildings[j]) / (i-j);
                // 첫 건물이거나, 기울기가 더 작으면 보임
                if(j==i-1 || slope < maxSlopeLeft) {
                    visible++;
                    maxSlopeLeft = slope;
                }
            }

            // 오른족 탐색
            double maxSlopeRight = Double.MIN_VALUE;
            for(int j = i+1; j < N; j++) {
                // i 기준에서 오른쪽 j 건물까지의 기울기 계산
                double slope = (double)(buildings[i]-buildings[j]) / (i-j);
                // 첫 건물이거나, 기울기가 더 크면 보임
                if (j==i+1 || slope > maxSlopeRight) {
                    visible++;
                    maxSlopeRight = slope;
                }
            }

            answer = Math.max(answer, visible);
        }

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}
