package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		
//		String[] num = input.split("[+-]");
//		List<Integer> numList = new ArrayList<Integer>();
//		for(String s : num) {
//			numList.add(Integer.parseInt(s));
//		}
//		List<Character> operList = new ArrayList<Character>();
//		for(char c : input.toCharArray()) {
//			if(c=='+' || c=='-') {
//				operList.add(c);
//			}
//		}
//		System.out.println(numList);
//		System.out.println(operList);
		
		int answer = Integer.MAX_VALUE;
		String[] min = input.split("-");
		
		for(int i = 0; i < min.length; i++) {
			int sum = 0;
			
			String[] plus = min[i].split("\\+");
			
			for(int j = 0; j < plus.length; j++) {
				sum += Integer.parseInt(plus[j]);
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = sum;
			} else {
				answer -= sum;
			}
		}
		
		sb.append(answer);
		System.out.print(sb);
		br.close();
	}
}
