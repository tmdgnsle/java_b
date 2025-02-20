

import java.util.*;
import java.io.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }


        DFS(1);

        count -=1;


        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        count++;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
