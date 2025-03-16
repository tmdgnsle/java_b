import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] parent;
    static long[][] islands;
    static double E;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            islands = new long[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i][0] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i][1] = Long.parseLong(st.nextToken());
            }

            pq = new PriorityQueue<>();
            E = Double.parseDouble(br.readLine());
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double cost = calculateCost(islands[i][0], islands[i][1], islands[j][0], islands[j][1]);
                    pq.offer(new Edge(i, j, cost));
                }
            }

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int count = 0;
            double totalFee = 0;
            while (!pq.isEmpty() && count < N - 1) {
                Edge edge = pq.poll();
                if (find(edge.to) != find(edge.from)) {
                    union(edge.to, edge.from);
                    totalFee += edge.cost;
                    count++;
                }
            }

            System.out.println("#" + t + " " + Math.round(totalFee));


        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return parent[a];
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static double calculateCost(long x1, long y1, long x2, long y2) {
        long dx = x1 - x2;
        long dy = y1 - y2;

        long distance = dx * dx + dy * dy;
        return E * distance;
    }
}