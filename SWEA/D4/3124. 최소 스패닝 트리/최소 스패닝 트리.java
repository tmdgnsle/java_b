import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static ArrayList<Edge>[] edges;
    static int V, E;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_3124.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edges[A].add(new Edge(B, C));
                edges[B].add(new Edge(A, C));
            }

            // 한 번만 프림 알고리즘 실행 (정점 1에서 시작)
            long result = prim();
            System.out.println("#" + t + " " + result);
        }
    }

    static long prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        visited[1] = true; // 1번 정점부터 시작

        // 시작 정점의 모든 인접 간선 추가
        for (Edge edge : edges[1]) {
            pq.add(edge);
        }

        int count = 1; // 이미 시작 정점을 방문함
        long sum = 0;

        while (!pq.isEmpty() && count < V) {
            Edge current = pq.poll();

            if (visited[current.destination]) continue;

            visited[current.destination] = true;
            sum += current.weight;
            count++;

            // 새로 추가된 정점의 인접 간선들 추가
            for (Edge edge : edges[current.destination]) {
                if (!visited[edge.destination]) {
                    pq.add(edge);
                }
            }
        }

        // 모든 정점을 방문했는지 확인 (모든 정점이 연결되어 있는지)
        if (count < V) {
            // 그래프가 연결되어 있지 않은 경우 (문제에 따라 다름)
            return -1;
        }

        return sum;
    }
}