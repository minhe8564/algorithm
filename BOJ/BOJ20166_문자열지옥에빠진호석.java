/*
 * BOJ 20166번 : 문자열 지옥에 빠진 호석
 * 메모리 : 152,372kb
 * 시간 : 576ms
 * 
 * 1. 문자열 중 가장 긴 길이  maxLen 구하기
 * 2. 모든 좌표에서 시작해서 8방향 bfs 수행
 * 3. maxLen 이하의 모든 문자열 HashMap 에 저장하기
 * 3-1. 경계 넘어가면 반대편 이동
 * 4. 문자열을 누적하면서 각 문자열의 등장 횟수 세기
 */

import java.io.*;
import java.util.*;

public class BOJ20166_문자열지옥에빠진호석 {
    static int N, M, K;
    static String[][] board;
    static String[] makeWord;
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };
    static HashMap<String, Integer> map;
    static int maxLen;

    static class Node {
        int x, y;
        String s;
        public Node(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new String[N][M];
        for (int n = 0; n < N; n++) {
        	String line = br.readLine();
            for(int m = 0; m < M; m++) {
            	board[n][m] = String.valueOf(line.charAt(m));
            }
        }

        makeWord = new String[K];
        maxLen = 0;

        for (int k = 0; k < K; k++) {
            makeWord[k] = br.readLine(); 
            maxLen = Math.max(maxLen, makeWord[k].length());
        }

        map = new HashMap<>();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                Queue<Node> q = new ArrayDeque<>();
                q.add(new Node(n, m, board[n][m]));
                map.put(board[n][m], map.getOrDefault(board[n][m], 0) + 1);

                while (!q.isEmpty()) {
                    Node curr = q.poll();

                    if (curr.s.length() >= maxLen) continue;

                    for (int d = 0; d < 8; d++) {
                        int nx = (curr.x+dx[d] + N) % N;
                        int ny = (curr.y+dy[d] + M) % M;

                        q.add(new Node(nx, ny, curr.s+board[nx][ny]));
                        map.put(curr.s+board[nx][ny], map.getOrDefault(curr.s+board[nx][ny], 0) + 1); // 이미 존재하면 +1
                    }
                }
            }
        }

        for (String word : makeWord) {
            sb.append(map.getOrDefault(word, 0)).append("\n"); // 등장 횟수 카운팅
        }

        System.out.print(sb);
    }
}
