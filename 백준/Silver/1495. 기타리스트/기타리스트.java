import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] vol = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            vol[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] d = new boolean[N+1][M+1];
        d[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(!d[i-1][j]) continue;

                if(j + vol[i] <= M){
                    d[i][j+vol[i]] = true;
                }

                if(j - vol[i] >= 0){
                    d[i][j-vol[i]] = true;
                }

            }
        }

        int result = -1;
        for (int i = M; i >= 0; i--) {
            if(d[N][i]){
                result = i;
                break;
            }
        }

        System.out.println(result);



    }
}