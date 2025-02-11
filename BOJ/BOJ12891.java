package algorithm;

import java.io.*;
import java.util.*;

public class BOJ12891 {

    static int[] check = new int[4];  // 최소로 필요한 A, C, G, T 개수
    static int[] currNum = new int[4]; // 현재 윈도우 내 A, C, G, T 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] pw = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            addChar(pw[i]);
        }

        int answer = 0;
        if (isValid()) answer++; // 초기 윈도우 검사

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            addChar(pw[i]);      // 새로운 문자 추가
            removeChar(pw[i - P]); // 이전 문자 제거
            if (isValid()) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    // 현재 윈도우가 조건을 만족하는지 검사
    static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (currNum[i] < check[i]) return false;
        }
        return true;
    }

    // 문자를 추가하면서 카운트 증가
    static void addChar(char c) {
        if (c == 'A') currNum[0]++;
        if (c == 'C') currNum[1]++;
        if (c == 'G') currNum[2]++;
        if (c == 'T') currNum[3]++;
    }

    // 문자를 제거하면서 카운트 감소
    static void removeChar(char c) {
        if (c == 'A') currNum[0]--;
        if (c == 'C') currNum[1]--;
        if (c == 'G') currNum[2]--;
        if (c == 'T') currNum[3]--;
    }
}
