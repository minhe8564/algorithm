package algorithm;

import java.io.*;
import java.util.*;

public class BOJ4335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) break;
			
			boolean isHonest = true;
			int lower = 1;
			int upper = 10;
			
			while(true) {
				String answer = br.readLine();
				
				if(answer.equals("too high"))
					upper = Math.min(upper, input-1);
				else if(answer.equals("too low"))
					lower = Math.max(lower, input+1);
				else if(answer.equals("right on")) {
					if(input < lower || input > upper)
						isHonest = false;
					System.out.println(isHonest ? "Stan may be honest" : "Stan is dishonest");
					break;
				}
				
				input = Integer.parseInt(br.readLine());
			}
		}
		
		br.close();
	}
}
