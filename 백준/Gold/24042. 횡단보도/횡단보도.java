import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int idx; // 이 횡단보도가 켜지는 시작 Offset

        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        long time;

        Node(int v, long time) {
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //입력 순서가 곧 신호 순서
        //1번째 순서 -> 시간 0, 2번째 신호 -> 시간 1, ...
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, i));
            graph[b].add(new Edge(a, i));
        }
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0L;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.time != dist[cur.v]) continue;
            if (cur.v == N) break;

            for (Edge next : graph[cur.v]) {
                long startTime;

                if (cur.time <= next.idx) {
                    startTime = next.idx;
                } else {
                    long diff = cur.time - next.idx;
                    long k = (diff + M - 1) / M; // 올림
                    startTime = next.idx + k * (long) M;
                }

                long nextTime = startTime + 1;

                if (dist[next.to] > nextTime) {
                    dist[next.to] = nextTime;
                    pq.offer(new Node(next.to, nextTime));
                }
            }
        }

        System.out.println(dist[N]);

    }
}