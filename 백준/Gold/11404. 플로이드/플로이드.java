import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    costs[i][j] = 0; // 자기 자신으로 가는 비용은 0
                } else {
                    costs[i][j] = Integer.MAX_VALUE; // 나머지는 무한대
                }
            }
        }


        int r = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costs[x][y] = Math.min(costs[x][y], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE) {
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(costs[i][j] == Integer.MAX_VALUE){
                    System.out.print("0 ");
                } else {
                    System.out.print(costs[i][j] + " ");
                }
                
            }
            System.out.println();
        }

    }

}