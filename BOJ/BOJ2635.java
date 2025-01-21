import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2635 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int maxLen = 0; // 최대 길이 저장
        int maxSecond = 0; // 최적의 두 번째 숫자 저장

        for (int n = N; n >= 0; n--) {
            int first = N;
            int second = n;
            int count = 2; // 시작 값 포함, 최소 2개

            while (first - second >= 0) {
                int third = first - second;
                first = second;
                second = third;
                count++;
            }

            // 최대 길이와 두 번째 값 업데이트
            if (maxLen < count) {
                maxLen = count;
                maxSecond = n;
            }
        }

        // 결과 생성
        sb.append(maxLen).append("\n");
        sb.append(N).append(" ").append(maxSecond).append(" ");

        int first = N;
        int second = maxSecond;
        while (first - second >= 0) {
            int third = first - second;
            first = second;
            second = third;
            sb.append(second).append(" ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}
