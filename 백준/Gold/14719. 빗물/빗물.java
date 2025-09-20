import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int n = Integer.parseInt(st.nextToken());

            for(int j = h-1; j > h-1-n; j--){
                map[j][i] = true;
            }
        }
        int answer = 0;

        for (int i = 0; i < h; i++) {
            boolean left = false;
            boolean right = false;
            int count = 0;
            for (int j = 0; j < w; j++) {
                if(map[i][j]){
                    if(!left){
                        left = true;
                    }else {
                        answer += count;
                        count = 0;
                    }
                } else {
                    if(left){
                        count ++;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}