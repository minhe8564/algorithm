import java.io.*;
import java.util.*;

public class BOJ28279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        for(int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                int x = Integer.parseInt(st.nextToken());
                d.offerFirst(x);
            }
            else if(command == 2){
                int x = Integer.parseInt(st.nextToken());
                d.offerLast(x);
            }

            switch (command) {
                case 3:
                    if(!d.isEmpty())
                        sb.append(d.pollFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case 4:
                    if(!d.isEmpty())
                        sb.append(d.pollLast()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case 5:
                    sb.append(d.size()).append("\n");
                    break;
                case 6:
                    if(d.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case 7:
                    if(!d.isEmpty())
                        sb.append(d.peekFirst()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case 8:
                    if(!d.isEmpty())
                        sb.append(d.peekLast()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
