//  지구 온난화

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minI = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE;
        int minJ = Integer.MAX_VALUE;
        int maxJ = Integer.MIN_VALUE;


        String[][] map = new String[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                String s = str.substring(j, j + 1);
                map[i][j] = s;

            }
        }

        ArrayList<int[]> nm = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("X")) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                            count++;
                            continue;
                        }
                        if (map[ni][nj].equals(".")) count++;
                    }
                    if (count < 3) {
                        nm.add(new int[] {i, j});

                    }
                }
            }
        }

        String[][] newMap = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = ".";
            }
        }

        for(int[] pos: nm){
            int di = pos[0];
            int dj = pos[1];

            newMap[di][dj] = "X";

            minI = Math.min(minI, di);
            minJ = Math.min(minJ, dj);
            maxI = Math.max(maxI, di);
            maxJ = Math.max(maxJ, dj);

        }

        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }

    }
}