package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>();
		for (int n = 0; n < N; n++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<String>(set);
		list.sort((a, b) -> { 
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});
		
		for(String i : list) {
			System.out.println(i);
		}
	}

}
