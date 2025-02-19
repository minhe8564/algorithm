import java.io.*;
import java.util.*;

public class Solution23677_순열기본 {
	static int N, R;
	static int[] input;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			input = new int[N];
			result = new int[R];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				input[n] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(input);
			
			sb.append("#").append(t).append("\n");
			perm(0);
			sb.append(count);
		}
		System.out.println(sb);
		br.close();
		
	}
	
	private static void perm(int cnt) {
		// 기저
		if(cnt == R) {
			count++;
			for(int i : result) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 유도
		for(int n = 0; n < N; n++) {
			if(visited[n]) continue;
			
			result[cnt] = input[n];
			visited[n] = true;
			perm(cnt+1);
			visited[n] = false;
		}
	}

}
