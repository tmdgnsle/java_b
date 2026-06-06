import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for(int i = 0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        for(int i = 0; i<N; i++){
            long bigCount = 0;
            for(int j = i; j<N; j++){
                if(a[i] < a[j]) bigCount++;

                if(a[i] > a[j]) answer += bigCount;
            }
        }

        System.out.println(answer);
        
    }
}