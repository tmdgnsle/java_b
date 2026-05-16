import java.util.*;

class Solution {
    static ArrayList<Integer>[][] graph;
    static int n, k;
    static int answer = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;

        graph = new ArrayList[4][n + 1];

        for (int t = 1; t <= 3; t++) {
            for (int i = 1; i <= n; i++) {
                graph[t][i] = new ArrayList<>();
            }
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int type = edge[2];

            graph[type][a].add(b);
            graph[type][b].add(a);
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        answer = 1;
        dfs(0, infected);

        return answer;
    }

    static void dfs(int depth, boolean[] infected) {
        answer = Math.max(answer, count(infected));

        if (depth == k) return;

        for (int type = 1; type <= 3; type++) {
            boolean[] next = spread(infected, type);
            dfs(depth + 1, next);
        }
    }

    static boolean[] spread(boolean[] infected, int type) {
        boolean[] next = infected.clone();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (next[i]) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph[type][cur]) {
                if (!next[nxt]) {
                    next[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        return next;
    }

    static int count(boolean[] infected) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) cnt++;
        }
        return cnt;
    }
}