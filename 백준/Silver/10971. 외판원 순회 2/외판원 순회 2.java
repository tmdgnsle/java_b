import java.io.*;
import java.util.*;

public class Main {
    static int[][] price;
    static int N;
    static boolean[] v;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        v = new boolean[N];
        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt();

        System.out.println(result);
    }

    static void bt(){
        if(arr.size() == N){
            int sum = 0;
            int first = arr.get(0);
            int last = arr.get(N-1);
            if(price[last][first] == 0) return;
            for (int i = 0; i < N - 1; i++) {
                int p1 = arr.get(i);
                int p2 = arr.get(i+1);
                if(price[p1][p2] == 0) return;
                sum += price[p1][p2];
            }
            sum += price[last][first];
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!v[i]){
                v[i] = true;
                arr.add(i);
                bt();
                v[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}