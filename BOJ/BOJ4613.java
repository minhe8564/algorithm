import java.io.*;

public class Main {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while((str = br.readLine()).charAt(0) != '#') {
			int sum = 0;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c != ' ') {
					sum += (i+1) * (c-'A'+1);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
