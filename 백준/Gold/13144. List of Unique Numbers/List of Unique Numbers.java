import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        int right = 0;
        long answer = 0;

        for(int left = 0; left<N; left++){
            while(right < N && !visited[arr[right]]){
                visited[arr[right]] = true;
                right++;
            }

            answer += (right - left);

            visited[arr[left]] = false;
        }

        System.out.println(answer);


    }
}