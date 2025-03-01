//  촌수계산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int p1, p2;
    static ArrayList<Integer>[] arr;
    static boolean v[];
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        v = new boolean[N + 1];
        result = -1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(0, p1);

        System.out.println(result);

    }

    static void dfs(int count, int current) {
        if (current == p2) {
            if (result == -1)
                result = count;
            else result = Math.min(result, count);

            return;
        }

        v[current] = true;

        for (int next: arr[current]){
            if(!v[next]){
                dfs(count+1, next);
            }
        }

    }
}