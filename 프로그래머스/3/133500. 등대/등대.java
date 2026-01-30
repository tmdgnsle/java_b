import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : lighthouse) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    static void dfs(int u) {
        visited[u] = true;

        dp[u][1] = 1;  // u를 켠다
        dp[u][0] = 0;  // u를 끈다

        for (int v : graph[u]) {
            if (visited[v]) continue;
            dfs(v);

            // u가 켜져 있으면 v는 켜도/꺼도 됨
            dp[u][1] += Math.min(dp[v][0], dp[v][1]);

            // u가 꺼져 있으면 (u-v) 간선을 커버하려면 v는 반드시 켜져야 함
            dp[u][0] += dp[v][1];
        }
    }
}