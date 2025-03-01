//  특정 거리의 도시 찾기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static int[] citys;
    static boolean[] v;
    static ArrayList<Integer>[] roads;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        citys = new int[N + 1];
        v = new boolean[N + 1];
        roads = new ArrayList[N + 1];
        result = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            roads[p1].add(p2);
        }

        bfs(X);

        if(result.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(result);
            for(int city : result){
                System.out.println(city);
            }
        }

    }

    static void bfs(int target) {
        v[target] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int distance = current[1];
            if (distance == K) result.add(pos);
            if (distance > K) break;

            for (int next : roads[pos]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(new int[]{next, distance + 1});
                }
            }
        }
    }
}