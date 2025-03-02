//  미로 만들기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 상: 0 우: 1 하: 2 좌:3

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[101][101];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = "#";
            }
        }

        int ci = 50;
        int cj = 50;

        int minI = ci;
        int maxI = ci;
        int minJ = cj;
        int maxJ = cj;

        map[ci][cj] = ".";
        int dir = 2; // 하
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            String move = s.substring(i, i + 1);
            switch (move) {
                case ("R"):
                    dir = (dir + 1) % 4;
                    break;
                case ("L"):
                    if(dir == 0){
                        dir = 3;
                    } else {
                        dir = dir -1;
                    }

                    break;
                case ("F"):
                    ci = ci + dx[dir];
                    cj = cj + dy[dir];

                    map[ci][cj] = ".";

                    minI = Math.min(minI, ci);
                    minJ = Math.min(minJ, cj);
                    maxI = Math.max(maxI, ci);
                    maxJ = Math.max(maxJ, cj);

                    break;
            }
        }

        for (int i = minI; i <= maxI; i++) {
            
            for (int j = minJ; j <= maxJ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        

    }
}