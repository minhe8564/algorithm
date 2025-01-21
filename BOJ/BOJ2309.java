package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList();
		int total = 0;

		for (int i = 0; i < 9; i++) {
			list.add(Integer.parseInt(br.readLine()));
			total += list.get(i);
		}

		boolean found = false;
		int first = 0, second = 0;

		for (int i = 0; i < 9; i++) {
			first = list.get(i);
			for (int j = i+1; j < 9; j++) {
				second = list.get(j);
				if (first + second + 100 == total) {
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		
		list.remove((Integer) first);
		list.remove((Integer) second);
		
		Collections.sort(list);
		
		for(int i : list) {
			System.out.println(i);
		}
	}

}
