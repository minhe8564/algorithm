import java.io.*;
import java.util.*;

public class BOJ2805_나무자르기 {
	static int N, M;
	static int[] tree;
	static int maxHeight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 수확하고자 하는 나무 길이
		tree = new int[N];
		int maxTree = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			tree[n] = Integer.parseInt(st.nextToken());
			maxTree = Math.max(maxTree, tree[n]);
		}

		int min = 0, max = maxTree;
		maxHeight = 0;
		
		while(min <= max) {
			int mid = (min+max)/2;
			long sum = 0;
			
			for(int n = 0; n < N; n++) {
				if(tree[n] > mid) {
					sum += tree[n]-mid;
				}
			}
			
			if(sum >= M) {
//				System.out.println("min: "+min+" max: "+max+" mid: "+mid);
				maxHeight = mid;
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		
		sb.append(maxHeight);
		System.out.print(sb);
		br.close();
	}

}
