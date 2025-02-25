import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 노드에서 DFS 실행
            for (int i = 1; i <= V; i++) {
                if (isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if (isEven) System.out.println("YES");
            else System.out.println("NO");

        }
    }

    static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) {
            if (!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else if (check[start] == check[i]) {
                isEven = false;
            }
        }
    }


}
