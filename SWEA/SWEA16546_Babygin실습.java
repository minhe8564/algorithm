import java.io.*;
import java.util.*;

public class SWEA16546_Babygin실습 {
    static int[] input;
    static int[] temp;
    static boolean[] visited;
    static boolean result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); 
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            input = new int[6];
            temp = new int[6];
            visited = new boolean[6];
            result = false;

            for (int i = 0; i < 6; i++) {
                input[i] = str.charAt(i) - '0';
            }

            perm(0);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void perm(int depth) {
        if (depth == 6) {
            if (checkBabyGin(temp)) {
                result = true;
            }
//            count++;
//            System.out.println(Arrays.toString(input));
//            System.out.println(count);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
        	if(!visited[i]) {
        		visited[i] = true;
        		temp[depth] = input[i];
        		perm(depth+1);
        		visited[i] = false;
        	}
        }
    }

    // 앞 3자리, 뒤 3자리 확인
    private static boolean checkBabyGin(int[] arr) {
        return (isRun(arr, 0) || isTriplet(arr, 0)) && (isRun(arr, 3) || isTriplet(arr, 3));
    }

    // 연속된 숫자인지 확인 
    private static boolean isRun(int[] arr, int start) {
        return (arr[start] + 1 == arr[start + 1]) && (arr[start + 1] + 1 == arr[start + 2]);
    }

    // 같은 숫자가 3개인지 확인 
    private static boolean isTriplet(int[] arr, int start) {
        return (arr[start] == arr[start + 1]) && (arr[start + 1] == arr[start + 2]);
    }
}
