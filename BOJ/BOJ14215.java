package algorithm;

import java.io.*;
import java.util.*;

class BOJ14215 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        
        // 삼각형의 가장 긴 변이 나머지 변들의 합보다 작아야 함
        if(arr[0] + arr[1] > arr[2]) {
        	System.out.println(arr[0]+arr[1]+arr[2]);
        }
        else {
        	System.out.println((arr[0]+arr[1])*2 - 1);
        }
        
        br.close();
    }
}

