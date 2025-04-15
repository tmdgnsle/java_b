import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] scores = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, (o1, o2) -> o1[0] - o2[0]);

            int count = 1;
            int minScore = scores[0][1];

            for (int i = 1; i < N; i++) {
                if(scores[i][1] < minScore){
                    count++;
                    minScore = scores[i][1];
                }
            }

            System.out.println(count);

        }
    }
}