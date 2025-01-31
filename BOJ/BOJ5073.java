package algorithm;

import java.io.*;
import java.util.*;

public class BOJ5073 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y == 0 && z == 0) break;
			
			int max = Math.max(x, Math.max(y, z));
			int sum = x+y+z;
			
			if(max >= sum - max) {
				sb.append("Invalid").append("\n");
			}
			else if(x == y && y == z) {
				sb.append("Equilateral").append("\n");
			}
			else if(x == y || y == z || x == z) {
				sb.append("Isosceles").append("\n");
			}
			else {
				sb.append("Scalene").append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
