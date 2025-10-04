import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            // 스택의 크기가 폭발 문자열 길이 이상이면 확인
            if (stack.size() >= bombLen) {
                boolean isBomb = true;

                // 스택의 마지막 부분이 폭발 문자열과 일치하는지 확인
                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열이면 제거
                if (isBomb) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}