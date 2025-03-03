import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        int time = 1;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                String s = str.substring(j, j + 1);
                if (s.equals("O")) {
                    map[i][j] = 2;
                }
            }
        }


        while (time != N) {
            bomb(++time);
        }

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) System.out.print(".");
                else System.out.print("O");
            }
            System.out.println();
        }

    }

    static void bomb(int time) {
        ArrayList<int[]> arr =new ArrayList<>();
        if (time % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 3;
                    } else {
                        map[i][j]--;
                    }
                }
            }
        } else {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 1) {
                        arr.add(new int[]{i, j});
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                            arr.add(new int[]{nx, ny});
                        }
                    } else if (map[i][j] != 0)
                        map[i][j]--;

                }
            }
        }

        for(int[] a:arr){
            map[a[0]][a[1]] = 0;
        }


    }
}