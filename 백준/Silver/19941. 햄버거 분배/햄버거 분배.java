import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] table = new char[N];
        String str = br.readLine();
        for(int i = 0; i<N; i++){
            table[i] = str.charAt(i);
        }
        boolean[] can = new boolean[N];

        int answer = 0;
        for(int i = 0; i<N; i++){
            if(table[i] == 'P'){
                for(int j = i - K; j<= i + K; j++){
                    if(j < 0 || j >= N) continue;

                    if(table[j] == 'H' && !can[j]){
                        can[j] = true;
                        answer++;
                        break;
                    }

                }
            }
        }

        System.out.println(answer);


    }
}