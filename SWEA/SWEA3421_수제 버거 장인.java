import java.io.*;
import java.util.*;

// 부분 집합

public class Solution_3421_수제버거장인_이민희 {
	static int N, M;
	static List<int[]> list;
	static boolean[] isSelected;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			M = Integer.parseInt(st.nextToken()); // 궁합이 맞지 않는 재료의 쌍
			list = new ArrayList<int[]>();
			isSelected = new boolean[N + 1];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				list.add(new int[] { a, b });
			}

//			for (int[] i : list) {
//				System.out.println(Arrays.toString(i));
//			}

			cnt = 0;
			subset(0);
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void subset(int idx) {
		if (idx == N) {
			for (int[] i : list) {
				int a = i[0];
				int b = i[1];
				// 궁합이 맞지 않는 조합이 선택된 경우 제외
				if (!isSelected[a] && !isSelected[b]) { // a, b가 선택된 경우 제외
					return;
				}
			}
			cnt++;
			return;
		}

		isSelected[idx] = true;
		subset(idx + 1);

		isSelected[idx] = false;
		subset(idx + 1);
	}
}
