package algorithm;

import java.io.*;
import java.util.*;

public class BOJ9375_패션왕신해빈 {
	static int N;
	static Map<String, List<String>> map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<String, List<String>>();
			
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				map.putIfAbsent(type, new ArrayList<String>()); // type이 존재하지 않는 경우에만 추가
//				map.put(type, new ArrayList<String>());
				map.get(type).add(name);
			}
			System.out.println(map);
			
			int cnt = 1;
			for(List<String> list : map.values()) {
				cnt *= (list.size()+1); // 의상 종류마다 선택할 수 있는 경우 (의상수+1)
			}
			cnt--; // 아무 의상도 선택하지 않는 경우 제외 
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
