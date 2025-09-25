import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int point;
        int distance;

        public Node(int point, int distance){
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }
    static int N, M, X;
    static ArrayList<Node>[] arrs;
    static int[] distances;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arrs = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            arrs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            arrs[start].add(new Node(end, distance));
        }



        int[] totalDistances = new int[N+1];

        for(int i = 1; i<=N; i++){
            distances = new int[N+1];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[i] = 0;
            v = new boolean[N+1];
            djikstra(i);
            if(i == X){
                for(int j = 1; j<=N; j++){
                    totalDistances[j] += distances[j];
                }
            }else {
                totalDistances[i] += distances[X];
            }
        }

        int maxDistance = Integer.MIN_VALUE;


        for(int i = 1; i<=N; i++){
            if(totalDistances[i] > maxDistance){
                maxDistance = totalDistances[i];
            }
        }

        System.out.println(maxDistance);

    }

    static void djikstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int cp = current.point;
            int cd = current.distance;

            if(v[cp]) continue;
            v[cp] = true;

            for(Node node: arrs[cp]){
                int next = node.point;
                int nd = node.distance;

                if(cd + nd < distances[next]){
                    distances[next] = cd + nd;
                    pq.offer(new Node(next, distances[next]));
                }
            }

        }
    }
}