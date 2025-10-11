import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현재 높이보다 높은 건물들은 모두 끝남
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                count++;
            }

            // 같은 높이면 같은 건물이므로 스택에 추가 안 함
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            // 새로운 높이면 스택에 추가 (높이 0은 제외)
            if (y > 0) {
                stack.push(y);
            }
        }

        // 남아있는 건물들 카운트
        count += stack.size();

        System.out.println(count);
    }
}