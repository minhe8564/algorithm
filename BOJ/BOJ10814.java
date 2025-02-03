import java.io.*;
import java.util.*;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[n][0] = st.nextToken();
            arr[n][1] = st.nextToken();
        }

        Arrays.sort(arr, (o1, o2)
                -> Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0])));

        for (int n = 0; n < N; n++) {
            sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
