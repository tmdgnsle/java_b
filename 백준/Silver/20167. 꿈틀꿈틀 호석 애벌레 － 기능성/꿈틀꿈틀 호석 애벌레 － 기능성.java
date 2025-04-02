import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        move(0, 0, 0);

        System.out.println(result);


    }

    static void move(int current, int idx, int energy){
        if(current >= K){
            energy += current - K;
            current = 0;
        }

        if(idx == N){
            result = Math.max(result, energy);
            return;
        }

        if(current == 0){
            move(current, idx+1, energy);
            move(arr[idx], idx+1, energy);
        } else {
            move(current+arr[idx], idx+1, energy);
        }

    }
}