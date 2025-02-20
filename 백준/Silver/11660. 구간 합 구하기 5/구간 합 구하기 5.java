

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] prefix_sum = new long[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(j == 1){
                    prefix_sum[i][j] = prefix_sum[i-1][N] + Integer.parseInt(st.nextToken());
                } else {
                    prefix_sum[i][j] = prefix_sum[i][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long sum = 0;

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());



            for (int j = x1; j <= x2; j++) {
                if(y1 == 1){
                    sum += prefix_sum[j][y2] - prefix_sum[j-1][N];
                } else {
                    sum += prefix_sum[j][y2] - prefix_sum[j][y1 - 1];
                }
            }
            System.out.println(sum);
        }

    }
}
