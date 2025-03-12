/*
 * 메모리 : 53,828kb
 * 시간 : 708ms
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2310_어드벤처게임 {
    static ArrayList<Integer>[] nextRoom;
    static char[] room;
    static int[] money;
    static int N;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            room = new char[N+1];
            nextRoom = new ArrayList[N+1];
            money = new int[N+1];
            visited = new boolean[N+1][501]; 

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                room[i] = st.nextToken().charAt(0);
                money[i] = Integer.parseInt(st.nextToken());
                nextRoom[i] = new ArrayList<>();

                int roomNum;
                while ((roomNum = Integer.parseInt(st.nextToken())) != 0) {
                    nextRoom[i].add(roomNum);
                }
            }

            if (bfs()) {
            	sb.append("Yes").append("\n");
            } else {
            	sb.append("No").append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 1, room[1] == 'L' ? money[1] : 0 });
        visited[1][q.peek()[1]] = true; 

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRoom = curr[0];
            int currMoney = curr[1];

            if (currRoom == N) {
            	return true;
            }

            for (int next : nextRoom[currRoom]) {
                int nextMoney = currMoney;

                if (room[next] == 'L') { 
                    nextMoney = Math.max(nextMoney, money[next]);
                } else if (room[next] == 'T') { 
                    if (nextMoney < money[next]) continue; 
                    nextMoney -= money[next];
                }

                if (!visited[next][nextMoney]) {
                    visited[next][nextMoney] = true;
                    q.offer(new int[] { next, nextMoney });
                }
            }
        }

        return false; 
    }
}
