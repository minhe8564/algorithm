package algorithm;

import java.io.*;
import java.util.*;

public class BOJ17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split("");
		Stack<String> s = new Stack<String>();
		boolean inTag = false;

		for (int i = 0; i < input.length; i++) {
			String str = input[i];

			if (str.equals("<")) {
				if (!s.isEmpty()) {
					while (!s.isEmpty()) {
						sb.append(s.pop());
					}
				}
				inTag = true;
				sb.append("<");
			} else if (str.equals(">")) {
				inTag = false;
				sb.append(">");
			} else if (inTag) {
				sb.append(str);
			} else {
				if (str.equals(" ")) {

					while (!s.isEmpty()) {
						sb.append(s.pop());
					}
					sb.append(str);
				} else {
					s.push(str);
				}
			}
		}

		while (!s.isEmpty()) {
			sb.append(s.pop());
		}

		System.out.println(sb);
	}

}
