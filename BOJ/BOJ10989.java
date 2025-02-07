package algorithm;

import java.io.*;
import java.util.*;

public class BOJ10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long N = Integer.parseInt(br.readLine());
		// 값들을 전부 저장하는 것 -> 메모리 초과
//		List<Long> list = new LinkedList<>();
//		for(int n = 0; n < N; n++) {
//			long num = Long.parseLong(br.readLine());
//			list.add(num);
//		}
//		
//		list.sort((o1, o2) -> o1.compareTo(o2));
//		
//		for(long l : list) {
//			System.out.println(l);
//		}

		// 계수 정렬 활용
		int[] count = new int[10001];
		for (int n = 1; n <= N; n++) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
