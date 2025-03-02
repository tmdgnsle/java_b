//  숫자 정사각형

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = 1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int p = Integer.parseInt(str.substring(j, j + 1));
                arr[i][j] = p;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int p1 = arr[i][j];
                for (int k = j + 1; k < M; k++) {

                    int p2 = arr[i][k];
                    if (p1 == p2) {
                        int distance = k - j;
                        if (i + distance < N){
                            int p3 = arr[i + distance][j];
                            int p4 = arr[i + distance][k];

                            if ((p1 == p3) && (p2 == p4)) {
                                int a = (distance + 1) * (distance + 1);
                                max = Math.max(max, a);
                            }
                        }



                    }

                }
            }
        }

        System.out.println(max);


    }
}