import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o){
            return this.value - o.value;
        }
    }

    static int N, M;
    static PriorityQueue<Edge> pq;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        parent = new int[N+1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Edge(s, e, v));
        }

        int usedEdge = 0;
        int result = 0;

        while(usedEdge < N-1){
            Edge now = pq.poll();
            if(find(now.start) != find(now.end)){
                union(now.start, now.end);
                result+=now.value;
                usedEdge++;
            }
        }

        System.out.println(result);
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }
}