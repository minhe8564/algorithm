package algorithm;

import java.io.*;
import java.util.*;

public class BOJ10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<Integer>();
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push": 
				d.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.poll()).append("\n");
				break;
			case "size":
				sb.append(d.size()).append("\n");
				break;
			case "empty":
				if(d.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekFirst()).append("\n");
				break;
			case "back":
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

}
