import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] people = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        int[] sum = new int[N-X+1];
        for(int i = 0; i<X; i++){
            sum[0] += people[i];
        }
        for(int i = 1; i<N-X+1; i++){
            sum[i] = sum[i-1] - people[i-1] + people[i + X-1];
        }

        for(int i = 0; i<N-X+1; i++){
            if(sum[i] > max){
                max = sum[i];
                count = 1;
            }else if(sum[i] == max){
                count++;
            }
        }


        if(max == 0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(count);
        }


    }
}