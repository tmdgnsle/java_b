import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.value, o.value);
        }
    }

    static int N, M;
    static ArrayList<Node>[] arrs;
    static int[] dist;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrs = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        v = new boolean[N+1];
        for (int i = 0; i < N + 1; i++) {
            arrs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arrs[start].add(new Node(end, value));
            arrs[end].add(new Node(start, value));
        }

        dijkstra(1);

        System.out.println(dist[N]);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentNode = current.end;
            int currentValue = current.value;

            if(v[currentNode]) continue;
            v[currentNode] = true;

            for(Node neighbor: arrs[currentNode]){
                int next = neighbor.end;
                int weight = neighbor.value;

                if(currentValue + weight < dist[next]){
                    dist[next] = currentValue + weight;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
    }
}