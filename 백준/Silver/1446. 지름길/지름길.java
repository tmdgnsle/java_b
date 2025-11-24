import java.io.*;
import java.util.*;

public class Main {
    static class Road implements Comparable<Road>{
        int to, cost;
        Road(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 그래프 생성 (0~D)
        List<List<Road>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // 기본 도로: i -> i+1 (cost=1)
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Road(i + 1, 1));
        }

        // 지름길 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (e > D) continue;         // D 넘어가는 건 무시
            if (e - s <= w) continue;    // 지름길이 더 길면 무시

            graph.get(s).add(new Road(e, w));
        }

        // 다익스트라
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(0, 0));

        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Road next : graph.get(cur.to)) {
                int newCost = cur.cost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Road(next.to, newCost));
                }
            }
        }

        System.out.println(dist[D]);
    }
}