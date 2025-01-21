package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> widthCut = new ArrayList<>();
        ArrayList<Integer> heightCut = new ArrayList<>();
        
        // 시작점과 끝점을 기본적으로 추가
        widthCut.add(0);
        widthCut.add(h);
        heightCut.add(0);
        heightCut.add(w);
        
        for (int n = 0; n < N; n++) {
        	st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken()); // 0: 가로, 1: 세로
            int num = Integer.parseInt(st.nextToken());
            
            if (dir == 0) {
                widthCut.add(num);
            } else {
                heightCut.add(num);
            }
        }
        
        // 정렬
        Collections.sort(widthCut);
        Collections.sort(heightCut);
        
        // 최대 높이와 너비 계산
        int maxWidth = 0, maxHeight = 0;
        
        // 가로 방향 최대 간격 계산
        for (int i = 1; i < widthCut.size(); i++) {
            maxHeight = Math.max(maxHeight, widthCut.get(i) - widthCut.get(i - 1));
        }
        
        // 세로 방향 최대 간격 계산
        for (int i = 1; i < heightCut.size(); i++) {
            maxWidth = Math.max(maxWidth, heightCut.get(i) - heightCut.get(i - 1));
        }
        
        // 최대 면적 계산
        int maxArea = maxWidth * maxHeight;
        System.out.println(maxArea);
        
        br.close();
    }
}
