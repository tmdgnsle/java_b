import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] next;          // next[i] = i가 가리키는 숫자 a_i
    static boolean[] visited;   // DFS 방문 여부
    static boolean[] finished;  // DFS가 i에서 시작해 i를 완전히 처리했는지
    static ArrayList<Integer> answer = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        next = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            next[i] = Integer.parseInt(br.readLine().trim());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int x : answer) sb.append(x).append('\n');
        System.out.print(sb.toString());
    }

    static void dfs(int u) {
        visited[u] = true;
        int v = next[u];

        if (!visited[v]) {
            dfs(v);
        } else if (!finished[v]) {
            // 방문은 했지만 아직 '종료'되지 않은 v로 간다면, v를 포함한 사이클 발견
            int x = v;
            do {
                answer.add(x);
                x = next[x];
            } while (x != v);
        }

        finished[u] = true;
    }
}