package algorithm;

import java.io.*;
import java.util.*;

public class BOJ12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> line = new ArrayDeque<Integer>(); // 원래 줄
		Stack<Integer> currLine = new Stack<Integer>(); // 대기 줄
		int snack = 1;
		for (int n = 0; n < N; n++) {
			line.offer(Integer.parseInt(st.nextToken()));
		}

		while (!line.isEmpty() || !currLine.isEmpty()) {
			// 원래 줄에서 받을 수 있는지 확인
			if(!line.isEmpty() && line.peek() == snack) { 
				line.poll();
				snack++;
			}
			// 현재 대기 줄에서 받을 수 있는지 확인
			else if(!currLine.isEmpty() && currLine.peek() == snack) { 
				currLine.pop();
				snack++;
			}
			// 줄에서 못 받으면 스택 대기 줄로 이동
			else if(!line.isEmpty()) { 
				currLine.push(line.poll());
			} else {
				break;
			}
		}

		System.out.println(snack-1 == N ? "Nice" : "Sad");
		br.close();
	}

}
