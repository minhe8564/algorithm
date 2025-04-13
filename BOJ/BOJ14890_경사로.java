/*
 * BOJ 14890번 : 경사로
 * 메모리 : 12,856kb
 * 시간 : 88ms
 */

import java.io.*;
import java.util.*;

public class BOJ14890_경사로 {
    static int N, L;
    static int[][] map;
    static int[] row;
    static int[] col;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        // 1. 행 확인
        row = new int[N];
        for (int i = 0; i < N; i++) {
            row = map[i];
            if(check(row)){
                answer++;
            }
        }

        // 2. 열 확인
        col = new int[N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }
            if(check(col)){
                answer++;
            }
        }

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }

    public static boolean check(int[] map) {
        boolean[] runway = new boolean[N];

        for(int i = 0; i < N-1; i++) {
            if(map[i] == map[i+1]) continue; // 지형 높이 동일한 경우

            else if(map[i]-1==map[i+1]) { // 내려가는 경사로
                for(int j = i+1; j < i+1+L; j++){
                    if(j >= N || map[i+1]!=map[j] || runway[j])  return false;
                    runway[j]=true;
                }
            }

            else if(map[i]+1==map[i+1]) { // 올라가는 경사로
                for(int j = i; j > i-L; j--){
                    if(j < 0 || map[i]!=map[j] || runway[j])  return false;
                    runway[j]=true;
                }
            }

            else return false; // 지형 높이 2 이상인 경우
        }
        return true;
    }
}
