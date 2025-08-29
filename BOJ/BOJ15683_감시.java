/*
 * BOJ 15683번 : 감시
 * 메모리 : 90,940kb
 * 시간 : 268ms
 * 
 * 1번 : 한 방향 (상하좌우)
 * 2번 : 서로 반대되는 두 방향 (좌우, 상하)
 * 3번 : 직각 두 방향 (상우, 우하, 하좌, 좌상)
 * 4번 : 세 방향 (상좌우, 상우하, 우하좌, 하좌상)
 * 5번 : 네 방향(모두) (상하좌우)
 */

import java.io.*;
import java.util.*;

public class BOJ15683_감시 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static List<CCTV> cctvs = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
                if(arr[n][m] >= 1 && arr[n][m] <= 5) {
                    cctvs.add(new CCTV(n, m, arr[n][m]));
                }
            }
        }

        result = Integer.MAX_VALUE;
        dfs(0, arr); // idx, arr[][]
        sb.append(result);
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int idx, int[][] arr) {
        if(idx == cctvs.size()) {
            result = Math.min(result, countArr(arr));
            return;
        }

        CCTV ctv = cctvs.get(idx);
        int[][] options = getDir(ctv.type);

        for(int[] dirs :  options) {
            int[][] copy = new int[N][M];
            for(int n = 0; n < N; n++) {
                copy[n] = Arrays.copyOf(arr[n], M);
            }
            for(int d : dirs) {
                watch(ctv.x, ctv.y, d, copy);
            }
            dfs(idx+1, copy);
        }
    }

    // 특정 방향으로 감시 표시
    public static void watch(int x, int y, int dir, int[][] arr){
        int nx = x;
        int ny = y;
        while(true) {
            nx += dx[dir];
            ny += dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = -1;
            }
        }
    }

    // CCTV 타입별 가능한 방향 조합
    public static int[][] getDir(int type) {
        switch (type) {
            case 1:
                return new int[][]{{0}, {1}, {2}, {3}}; // 상, 하, 좌, 우
            case 2:
                return new int[][]{{0, 1}, {2, 3}}; // 상하, 좌우
            case 3:
                return new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}; // 상우, 우하, 하좌, 좌상
            case 4:
                return new int[][]{{0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}}; // 상좌우, 상하우, 상하좌, 하좌우
            case 5:
                return new int[][]{{0, 1, 2, 3}}; // 상하좌우
        }
        return new int[0][];
    }

    // 사각지대 개수 세기
    public static int countArr(int[][] arr) {
        int ans = 0;
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(arr[n][m] == 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
