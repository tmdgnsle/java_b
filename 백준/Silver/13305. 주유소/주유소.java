import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N-1];
        int[] prices = new int[N];
        long answer = 0;


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int price = Integer.parseInt(st.nextToken());
            if(i == 0) prices[i] = price;
            else prices[i] = Math.min(prices[i-1], price);
        }

        for(int i = 0; i<N-1; i++){
            answer += prices[i] * dist[i];
        }

        System.out.println(answer);


    }
}