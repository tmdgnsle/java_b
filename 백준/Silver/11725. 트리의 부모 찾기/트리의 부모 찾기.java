//  트리의 부모 찾기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] result;
    static ArrayList<Integer>[] arr;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N + 1];
        v = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            arr[p1].add(p2);
            arr[p2].add(p1);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int current) {
        v[current] = true;

        for (int next : arr[current]) {
            if (!v[next]) {
                v[next] = true;
                result[next] = current;
                dfs(next);
            }
        }
    }
}