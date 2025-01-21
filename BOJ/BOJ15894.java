import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long n = Integer.parseInt(br.readLine()); // 가장 아랫 부분의 정사각형 개수
		
		// n=1, answer=4 1*4
		// n=2, answer=8 2*4
		// n=3, answer=12 3*4
		
		sb.append(n*4);
		System.out.println(sb);
	}

}
