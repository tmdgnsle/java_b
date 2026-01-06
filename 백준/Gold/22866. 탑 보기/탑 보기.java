import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[N];      // 각 건물에서 보이는 건물 수
        int[] near = new int[N];     // 가장 가까운 건물 인덱스 (0-based), 없으면 -1로
        Arrays.fill(near, -1);

        // 1) 왼쪽 방향 스캔
        Stack<Integer> stack = new Stack<>();   // 인덱스를 넣음
        for (int i = 0; i < N; i++) {
            // 나보다 작거나 같은 높이는 가려지므로 스택에서 제거
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }

            // 스택에 남은 건물들은 i에서 왼쪽으로 보이는 건물들
            cnt[i] += stack.size();

            // 그 중 가장 가까운 건물 후보 = 스택 top
            if (!stack.isEmpty()) {
                int j = stack.peek();
                updateNear(i, j, near);
            }

            stack.push(i);
        }

        // 2) 오른쪽 방향 스캔
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }

            cnt[i] += stack.size();

            if (!stack.isEmpty()) {
                int j = stack.peek();
                updateNear(i, j, near);
            }

            stack.push(i);
        }

        // 3) 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (cnt[i] == 0) {
                sb.append(0).append('\n');
            } else {
                sb.append(cnt[i]).append(' ')
                        .append(near[i] + 1).append('\n');  // 1-based로 출력
            }
        }
        System.out.print(sb);
    }

    // i번째 건물에서 j번째 건물 후보를 보고 near[i] 갱신
    private static void updateNear(int i, int j, int[] near) {
        if (near[i] == -1) {
            near[i] = j;
            return;
        }

        int curDist = Math.abs(i - near[i]);
        int newDist = Math.abs(i - j);

        // 더 가깝거나, 거리가 같으면 번호가 더 작은 쪽
        if (newDist < curDist || (newDist == curDist && j < near[i])) {
            near[i] = j;
        }
    }
}