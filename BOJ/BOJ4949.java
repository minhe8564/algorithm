package algorithm;

import java.io.*;
import java.util.*;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[') {
                    s.push(c);
                } 
                else if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    s.pop();
                } 
                else if (c == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    s.pop();
                }
            }

            if (!s.isEmpty()) isBalanced = false;

            System.out.println(isBalanced ? "yes" : "no");
        }

        br.close();
    }
}
