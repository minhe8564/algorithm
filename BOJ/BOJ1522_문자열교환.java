/*
 * BOJ 1522번 : 문자열 교환
 * 메모리 : 11,520kb
 * 시간 : 64ms
 */

import java.io.*;

public class BOJ1522_문자열교환 {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        answer = 0;

        int aCount = 0;
        int bCount = 0;

        for(char c : str.toCharArray()) {
            if(c == 'a') aCount++;
        }

        for(int i = 0; i < aCount; i++){
            if(str.charAt(i) == 'b') bCount++;
        }

        answer = bCount;

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == 'b') bCount--;
            if(str.charAt((i+aCount-1) % str.length()) == 'b') bCount++;
            answer = Math.min(answer, bCount);
        }

        sb.append(answer);
        System.out.print(sb);
        br.close();
    }
}
