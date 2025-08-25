/*
 * BOJ 1283번 : 단축키 지정
 * 메모리 : 11,428kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1283_단축키지정 {
    static int N;
    static int[] alphaBig = new int[26];
    static int[] alphaSmall = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            boolean done = false;

            int start = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (j == 0 || s.charAt(j - 1) == ' ') {
                    if (Character.isLetter(c)) {
                        if (Character.isUpperCase(c)) {
                            if (alphaBig[c - 'A'] == 0) {
                                alphaBig[c - 'A'] = 1;
                                alphaSmall[Character.toLowerCase(c) - 'a'] = 1;
                                sb.append('[').append(c).append(']');
                                done = true;
                                sb.append(s.substring(j + 1));
                                break;
                            }
                        } else {
                            if (alphaSmall[c - 'a'] == 0) {
                                alphaSmall[c - 'a'] = 1;
                                alphaBig[Character.toUpperCase(c) - 'A'] = 1;
                                sb.append('[').append(c).append(']');
                                done = true;
                                sb.append(s.substring(j + 1));
                                break;
                            }
                        }
                    }
                }
                sb.append(c);
            }

            if (!done) {
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!done && Character.isLetter(c)) {
                        if (Character.isUpperCase(c)) {
                            if (alphaBig[c - 'A'] == 0) {
                                alphaBig[c - 'A'] = 1;
                                alphaSmall[Character.toLowerCase(c) - 'a'] = 1;
                                sb2.append('[').append(c).append(']');
                                done = true;
                                continue;
                            }
                        } else {
                            if (alphaSmall[c - 'a'] == 0) {
                                alphaSmall[c - 'a'] = 1;
                                alphaBig[Character.toUpperCase(c) - 'A'] = 1;
                                sb2.append('[').append(c).append(']');
                                done = true;
                                continue;
                            }
                        }
                    }
                    sb2.append(c);
                }
                sb = sb2;
            }

            System.out.println(sb);
        }
    }
}
