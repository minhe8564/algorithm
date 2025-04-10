/*
 * SWEA 2805번 : 농작물 수확하기
 * 메모리 : 27,648kb
 * 시간 : 94ms
 */

import java.io.*;
import java.util.*;
 
public class SWEA2805_농작물수확하기 {
    static int N;
    static int[][] map;
    static int sum;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            sum = 0;
 
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
 
            int center = N/2; 
            for (int i = 0; i < N; i++) {
                int start = Math.abs(center-i);
                int end = N-start;
 
                for (int j = start; j < end; j++) {
                    sum += map[i][j];
                }
            }
 
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
 
        System.out.print(sb);
        br.close();
    }
}


import java.io.*;
import java.util.*;
 
public class SWEA2805_농작물수확하기 {
    static int N;
    static int[][] map;
    static int sum;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            sum = 0;
 
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
 
            int center = N/2; 
            for (int i = 0; i < N; i++) {
                int start = Math.abs(center-i);
                int end = N-start;
 
                for (int j = start; j < end; j++) {
                    sum += map[i][j];
                }
            }
 
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
 
        System.out.print(sb);
        br.close();
    }
}
