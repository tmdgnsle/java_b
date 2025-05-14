import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static ArrayList<Integer>[] arr;

    static boolean[] v;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                arr[p1].add(p2);
                arr[p2].add(p1);
            }


            v = new boolean[N + 1];
            v[1] = true;
            result = new ArrayList<>();
            bfs(1);


            System.out.println("#" + t + " " + result.size());

        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int max = arr[start].size();

        int count = 0;

        while (!queue.isEmpty() && count <= max) {
            int current = queue.poll();
            for (int next : arr[current]) {
                if (!v[next]) {
                    v[next] = true;
                    result.add(next);
                    queue.add(next);
                }

            }
            count++;
        }

    }

}