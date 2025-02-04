import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
//        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
            } else {
                switch (command) {
                    case "pop":
                        if (!q.isEmpty())
                            sb.append(q.poll()).append("\n");
                        else
                            sb.append("-1").append("\n");
                        break;
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;
                    case "empty":
                        if (q.isEmpty())
                            sb.append("1").append("\n");
                        else
                            sb.append("0").append("\n");
                        break;
                    case "front":
                        if (!q.isEmpty())
                            sb.append(q.peek()).append("\n");
                        else
                            sb.append("-1").append("\n");
                        break;
                    case "back":
                        if (!q.isEmpty())
                            sb.append(q.peekLast()).append("\n");
                        else
                            sb.append("-1").append("\n");
                        break;
                }
            }
        }
        System.out.println(sb);
        br.readLine();
    }
}
