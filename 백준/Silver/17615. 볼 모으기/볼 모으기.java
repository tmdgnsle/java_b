import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = Integer.MAX_VALUE;

        // 4가지 경우
        answer = Math.min(answer, solve(s, 'R', true));   // R 왼쪽
        answer = Math.min(answer, solve(s, 'R', false));  // R 오른쪽
        answer = Math.min(answer, solve(s, 'B', true));   // B 왼쪽
        answer = Math.min(answer, solve(s, 'B', false));  // B 오른쪽

        System.out.println(answer);
    }

    static int solve(String s, char target, boolean toLeft) {
        int n = s.length();
        int count = 0;

        if (toLeft) {
            int idx = 0;

            // 이미 왼쪽에 붙어있는 target 스킵
            while (idx < n && s.charAt(idx) == target) {
                idx++;
            }

            // 나머지에서 target 개수 세기
            for (int i = idx; i < n; i++) {
                if (s.charAt(i) == target) count++;
            }

        } else {
            int idx = n - 1;

            // 이미 오른쪽에 붙어있는 target 스킵
            while (idx >= 0 && s.charAt(idx) == target) {
                idx--;
            }

            // 나머지에서 target 개수 세기
            for (int i = 0; i <= idx; i++) {
                if (s.charAt(i) == target) count++;
            }
        }

        return count;
    }
}