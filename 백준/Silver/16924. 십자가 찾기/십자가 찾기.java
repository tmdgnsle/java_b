import java.io.*;
import java.util.*;

public class Main{
    static char[][] map;
    static boolean[][] v;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M];
        arr = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == '.') v[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '*'){

                    int count = 0;

                    while(true){
                        boolean complete = true;
                        for (int k = 0; k < count+1; k++) {
                            for (int l = 0; l < 4; l++) {
                                int nx = i + (k+1)*dx[l];
                                int ny = j + (k+1)*dy[l];

                                if(nx < 0 || ny < 0 || nx >=N || ny >= M){
                                    complete = false;
                                    break;
                                }

                                if(map[nx][ny] != '*'){
                                    complete = false;
                                    break;
                                }
                            }
                        }
                        if(complete) count++;
                        else break;

                    }

                    if(count >= 1){
                        v[i][j] = true;
                        for (int k = 0; k < count; k++) {
                            for (int l = 0; l < 4; l++) {
                                int nx = i + (k+1)*dx[l];
                                int ny = j + (k+1)*dy[l];
                                v[nx][ny] = true;
                            }
                        }
                        arr.add(new int[] {i+1, j+1, count});
                    }

                }
            }
        }
        boolean success = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!v[i][j]){
                    success = false;
                    break;
                }
            }
        }

        if(success){
            System.out.println(arr.size());
            for (int[] a: arr) {
                System.out.println(a[0] + " " + a[1] + " " + a[2]);
            }
        } else System.out.println(-1);


    }
}