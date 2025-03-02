package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1706_크로스워드 {
	static int R, C;
	static char[][] puzzle;
	static List<String> wordSort;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		puzzle = new char[R][C];
		for (int r = 0; r < R; r++) {
			String row = br.readLine();
			for (int c = 0; c < C; c++) {
				puzzle[r][c] = row.charAt(c);
			}
		}

		wordSort = new ArrayList<String>();
		
		for (int r = 0; r < R; r++) {
			String word = "";
			for (int c = 0; c < C; c++) {
				if(puzzle[r][c] != '#') {
					word += puzzle[r][c];
				} else {
					if(word.length() > 1) {
						wordSort.add(word);
					}
					word = "";
				}
			}
			
			// 마지막 단어가 끝나지 않은 경우 추가 
			if(word.length() > 1) {
				wordSort.add(word);
			}
		}
		
		for (int c = 0; c < C; c++) {
			String word = "";
			for (int r = 0; r < R; r++) {
				if(puzzle[r][c] != '#') {
					word += puzzle[r][c];
				} else {
					if(word.length() > 1) {
						wordSort.add(word);
					}
					word = "";
				}
			}
			
			// 마지막 단어가 끝나지 않은 경우 추가 
			if(word.length() > 1) {
				wordSort.add(word);
			}
		}

		if(!wordSort.isEmpty()) {
			Collections.sort(wordSort);
			sb.append(wordSort.get(0));
		}
		System.out.print(sb);
		br.close();
	}

}
