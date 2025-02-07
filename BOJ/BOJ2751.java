package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int n = 0; n < N; n++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		list.sort((o1, o2) -> o1.compareTo(o2));
		
		for(int n = 0; n < N; n++) {
			sb.append(list.get(n)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
