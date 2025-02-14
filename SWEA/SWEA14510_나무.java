import java.io.*;
import java.util.*;

public class SWEA14510_나무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 나무 개수
			int[] tree = new int[N]; // 나무의 높이
			int maxTree = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int n = 0; n < N; n++) {
				tree[n] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(maxTree, tree[n]);
			}

			int[] diff = new int[N];
			for (int n = 0; n < N; n++) {
				diff[n] = maxTree - tree[n];
			}
			
			int day = 0;
			int one = 0;
			int two = 0;
			
			for(int n = 0; n < N; n++) {
				one += diff[n] % 2;
				two += diff[n] / 2;
			}
			
			while(two > one+1) {
				two--;
				one += 2;
			}
			
			if(one > two) {
				day = one*2 - 1;
			} else {
				day = two*2;
			}

			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
