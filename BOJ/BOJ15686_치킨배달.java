package algorithm;

import java.io.*;
import java.util.*;

public class BOJ15686_치킨배달 {
    static int N, M;
    static int[][] city;
    static List<int[]> house = new ArrayList<int[]>();
    static List<int[]> chicken = new ArrayList<int[]>();
    static List<int[]> selectChicken = new ArrayList<int[]>();
    static int minDistance = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                city[r][c] = Integer.parseInt(st.nextToken());
                if (city[r][c] == 1) { // 집
                    house.add(new int[] { r, c });
                } else if (city[r][c] == 2) { // 치킨집
                    chicken.add(new int[] { r, c });
                }
            }
        }

        combination(0, 0);
        System.out.println(minDistance);
    }

    // M개의 치킨집을 선택하는 조합
    private static void combination(int start, int count) {
        if (count == M) {
            minDistance = Math.min(minDistance, chickenDistance());
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            selectChicken.add(chicken.get(i)); // 현재 치킨집 선택
            combination(i + 1, count + 1); // 다음 치킨집 선택
            selectChicken.remove(selectChicken.size() - 1); // 선택한 치킨집 제거(백트래킹)
        }
    }
    
    // 집-치킨집 거리 계산
    private static int chickenDistance() {
        int total = 0;
        
        for (int[] h : house) {
            int hX = h[0];
            int hY = h[1];
            int min = Integer.MAX_VALUE;
            
            for (int[] c : selectChicken) { // 선택된 치킨집들에 대해서만 계산
                int cX = c[0];
                int cY = c[1];
                int distance = Math.abs(hX - cX) + Math.abs(hY - cY);
                min = Math.min(min, distance);
            }
            
            total += min;
        }
        
        return total;
    }
}
