package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split("");
		Arrays.sort(arr, Collections.reverseOrder());
		for(String s : arr) {
			System.out.print(s);
		}
		br.close();
	}

}
