import java.io.*;
import java.util.*;

public class BOJ28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                s.add(x);
            }
            else {
                switch(command){
                    case 2 :
                        if(!s.isEmpty()) {
                            sb.append(s.pop()).append("\n");
                        }
                        else
                            sb.append("-1").append("\n");
                        break;
                    case 3:
                        sb.append(s.size()).append("\n");
                        break;
                    case 4:
                        if(!s.isEmpty())
                            sb.append("0").append("\n");
                        else
                            sb.append("1").append("\n");
                        break;
                    case 5:
                        if(!s.isEmpty())
                            sb.append(s.peek()).append("\n");
                        else
                            sb.append("-1").append("\n");
                        break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
