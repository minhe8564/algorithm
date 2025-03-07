import java.io.*;
import java.util.*;

public class BOJ1074_Z {
	static int N, R, C;
//	static int[][] arr;
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
//		arr = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		
		int size = (int) Math.pow(2, N);
		visit(0, 0, size);
		
//		for(int i = 0; i < Math.pow(2, N); i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		br.close();
	}
	
	private static void visit(int r, int c, int size) {
		if(size == 1) {
			System.out.print(num);
			return;
		}
		
		int newSize = size/2;
		if(R < r+newSize && C < c+newSize) { // 1사분면
			visit(r, c, newSize);
		} 
		if(R < r+newSize && C >= c+newSize) { // 2사분면
			num += (size*size)/4;
			visit(r, c+newSize, newSize);
		}
		if(R >= r+newSize && C < c+newSize) { // 3사분면
			num += ((size*size)/4) * 2;
			visit(r+newSize, c, newSize);
		}
		if(R >= r+newSize && C >= c+newSize) { // 4사분면
			num += ((size*size)/4) * 3;
			visit(r+newSize, c+newSize, newSize);
		}
		
		// 배열 전부 기록하게 되면, 메모리 초과 발생 (배열 생성 안됨!!!)
//		visit(r, c, S/2);
//		visit(r, c+S/2, S/2);
//		visit(r+S/2, c, S/2);
//		visit(r+S/2, c+S/2, S/2);
		
		return;
	}

}
