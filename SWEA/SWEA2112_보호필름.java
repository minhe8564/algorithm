/*
 * SWEA 2112번 : 보호 필름
 * 메모리 : 95,068kb
 * 시간 : 315ms
 * 
 * 1. 보호필름의 두께(D), 가로크기(W), 합격기준(K)
 * 2. 보호 필름의 단면 정보 (특성A(0), 특성B(1))
 * 3. 모든 세로 방향에 대해 동일한 특성의 셀이 K개 이상 연속적으로 있어야 한다.
 * 4. 약품을 투입하면, 가로 방향 셀들이 하나의 특성으로 변경된다.
 * 5. 성능검사를 통과하기 위한 최소 약품 투입 개수 출력
 * 6. 약품 투입 없이 성능검사를 통과하면 0 출력
 */
 
import java.io.*;
import java.util.*;
 
public class SWEA2112_보호필름 {
    static int D, W, K;
    static int[][] film;
    static int[] selectedRow;
    static int minCnt;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            for (int d = 0; d < D; d++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < W; w++) {
                    film[d][w] = Integer.parseInt(st.nextToken());
                }
            }
 
            minCnt = Integer.MAX_VALUE;
            if(checkPass()) minCnt = 0;
            else subset(0, 0);
 
            sb.append("#").append(t).append(" ").append(minCnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
 
    // 1. 성능검사 통과하는지 체크
    private static boolean checkPass() {
        for(int w = 0; w < W; w++){
            boolean isPassCol = false;
            for(int d = 0; d <= D-K; d++){
                boolean isPassRow = true;
                for(int k = 1; k < K; k++){
                    if(film[d][w] != film[d+k][w]){
                        isPassRow = false;
                        break;
                    }
                }
                if(isPassRow){
                    isPassCol = true;
                    break;
                }
            }
            if(!isPassCol) return false;
        }
        return true;
    }
 
    // 2. 약품 투입 행 - 부분집합
    private static void subset(int row, int cnt) {
        if(row == D) {
            if(checkPass()) {
                minCnt = Math.min(minCnt, cnt);
            }
            return;
        }
 
        if(cnt >= minCnt){
            return;
        }
 
        int[] backup = film[row].clone();
 
        subset(row+1, cnt); // 선택 안함
        Arrays.fill(film[row], 0); // 특성A
        subset(row+1, cnt+1);
        Arrays.fill(film[row], 1); // 특성B
        subset(row+1, cnt+1);
 
        film[row] = backup;
    }

 * 1. 보호필름의 두께(D), 가로크기(W), 합격기준(K)
 * 2. 보호 필름의 단면 정보 (특성A(0), 특성B(1))
 * 3. 모든 세로 방향에 대해 동일한 특성의 셀이 K개 이상 연속적으로 있어야 한다.
 * 4. 약품을 투입하면, 가로 방향 셀들이 하나의 특성으로 변경된다.
 * 5. 성능검사를 통과하기 위한 최소 약품 투입 개수 출력
 * 6. 약품 투입 없이 성능검사를 통과하면 0 출력
 */
 
import java.io.*;
import java.util.*;
 
public class Solution {
    static int D, W, K;
    static int[][] film;
    static int[] selectedRow;
    static int minCnt;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            for (int d = 0; d < D; d++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < W; w++) {
                    film[d][w] = Integer.parseInt(st.nextToken());
                }
            }
 
            minCnt = Integer.MAX_VALUE;
            if(checkPass()) minCnt = 0;
            else subset(0, 0);
 
            sb.append("#").append(t).append(" ").append(minCnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
 
    // 1. 성능검사 통과하는지 체크
    private static boolean checkPass() {
        for(int w = 0; w < W; w++){
            boolean isPassCol = false;
            for(int d = 0; d <= D-K; d++){
                boolean isPassRow = true;
                for(int k = 1; k < K; k++){
                    if(film[d][w] != film[d+k][w]){
                        isPassRow = false;
                        break;
                    }
                }
                if(isPassRow){
                    isPassCol = true;
                    break;
                }
            }
            if(!isPassCol) return false;
        }
        return true;
    }
 
    // 2. 약품 투입 행 - 부분집합
    private static void subset(int row, int cnt) {
        if(row == D) {
            if(checkPass()) {
                minCnt = Math.min(minCnt, cnt);
            }
            return;
        }
 
        if(cnt >= minCnt){
            return;
        }
 
        int[] backup = film[row].clone();
 
        subset(row+1, cnt); // 선택 안함
        Arrays.fill(film[row], 0); // 특성A
        subset(row+1, cnt+1);
        Arrays.fill(film[row], 1); // 특성B
        subset(row+1, cnt+1);
 
        film[row] = backup;
    }
}
