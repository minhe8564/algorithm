package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> students = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			students.add(n - Integer.parseInt(st.nextToken()), n+1);
		}
		
		for(int n = 0; n < N; n++) {
			sb.append(students.get(n)).append(" ");
		}
		
		System.out.println(sb);
	}

}
