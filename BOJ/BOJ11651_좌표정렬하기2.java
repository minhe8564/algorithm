package algorithm;

import java.io.*;
import java.util.*;

public class BOJ11651_좌표정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		Collections.sort(list, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

		for (int[] curr : list) {
			sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
