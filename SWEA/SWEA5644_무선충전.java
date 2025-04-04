/*
 * SWEA 5644번 : 무선충전
 * 메모리 : 27,896kb
 * 시간 : 107ms
 */

import java.io.*;
import java.util.*;

public class SWEA5644_무선충전 {
    static int M, A;
    static int[] userA, userB;
    static int[] dx = {0, -1, 0, 1, 0}; // 이동x, 상, 우, 하, 좌
    static int[] dy = {0, 0, 1, 0, -1};
    static int totalSum;
    static APinfo[] AP;

    static class APinfo {
        int x, y, c, p;
        public APinfo(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            userA = new int[M];
            userB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) userA[m] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) userB[m] = Integer.parseInt(st.nextToken());

            AP = new APinfo[A];
            for (int a = 0; a < A; a++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                AP[a] = new APinfo(y, x, c, p);
            }

            int[] userAStart = {0, 0};
            int[] userBStart = {9, 9};
            totalSum = 0;
            
            totalSum += getCharge(userAStart, userBStart); // 시작위치

            for (int m = 0; m < M; m++) {
                userAStart[0] += dx[userA[m]];
                userAStart[1] += dy[userA[m]];
                userBStart[0] += dx[userB[m]];
                userBStart[1] += dy[userB[m]];
                totalSum += getCharge(userAStart, userBStart);
            }

            sb.append(totalSum).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int getCharge(int[] APos, int[] BPos) {
        boolean[] APCheckA = new boolean[A];
        boolean[] APCheckB = new boolean[A];

        for (int a = 0; a < A; a++) {
            if (AP[a].c >= Math.abs(AP[a].x - APos[0]) + Math.abs(AP[a].y - APos[1])) {
                APCheckA[a] = true;
            }
            if (AP[a].c >= Math.abs(AP[a].x - BPos[0]) + Math.abs(AP[a].y - BPos[1])) {
                APCheckB[a] = true;
            }
        }

        int maxPower = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int aPower = APCheckA[i] ? AP[i].p : 0;
                int bPower = APCheckB[j] ? AP[j].p : 0;

                if (i==j && APCheckA[i] && APCheckB[j]) {
                    maxPower = Math.max(maxPower, AP[i].p);
                } else {
                    maxPower = Math.max(maxPower, aPower+bPower);
                }
            }
        }

        return maxPower;
    }
}
