/*
 * BOJ 9935번 : 문자열 폭발
 * 메모리 : 26,948kb
 * 시간 : 260ms
 */

import java.io.*;
import java.util.*;

public class BOJ9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boom = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            // boom 마지막 문자랑 같고, 길이가 충분할 때만 확인
            if(input.charAt(i) == boom.charAt(boom.length()-1) && sb.length() >= boom.length()) {
                boolean isBoom = true;
                for(int b = 0; b < boom.length(); b++) {
                    if(sb.charAt(sb.length()-boom.length()+b) != boom.charAt(b)) { // 하나라도 다르면 실패
                        isBoom = false;
                        break;
                    }
                }
                if(isBoom) { // boom!!!!!
                    sb.setLength(sb.length()-boom.length());
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

        br.close();
    }
}
