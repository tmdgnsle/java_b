//  체스

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] chess = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int kc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < kc; i++) {
            int ki = Integer.parseInt(st.nextToken());
            int kj = Integer.parseInt(st.nextToken());
            chess[ki-1][kj-1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int qc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < qc; i++) {
            int qi = Integer.parseInt(st.nextToken());
            int qj = Integer.parseInt(st.nextToken());
            chess[qi-1][qj-1] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int pc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pc; i++) {
            int pi = Integer.parseInt(st.nextToken());
            int pj = Integer.parseInt(st.nextToken());
            chess[pi-1][pj-1] = 3;
        }

        int[] kx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] ky = {2, -2, 2, -2, 1, -1, 1, -1};
        int[] qx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] qy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(chess[i][j] == 2){
                    for (int k = 0; k < 8; k++) {
                        int ni = i + kx[k];
                        int nj = j + ky[k];

                        if(ni < 0 || nj < 0 || ni >=N || nj >=M) continue;
                        if(chess[ni][nj] != 0) continue;
                        chess[ni][nj] = -1;
                    }
                } else if(chess[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int nx = i;
                        int ny = j;
                        while(true){
                            nx = nx + qx[k];
                            ny = ny + qy[k];
                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                            if(chess[nx][ny] == 0 || chess[nx][ny] == -1) chess[nx][ny] = -1;
                            else break;


                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(chess[i][j] == 0) count++;
            }
        }

        System.out.println(count);



    }
}