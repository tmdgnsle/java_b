import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] B;
    static int zero = 0; // 0인거 개수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2*N + 1]; // 내구도
        B = new boolean[N+1]; // 로봇 유무
        Arrays.fill(B, false);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2*N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        while (simulate()) {
            answer++;
        }

        System.out.println(answer);


    }


    static boolean simulate(){
        int[] A_copy = new int[A.length];
        boolean[] B_copy = new boolean[B.length];
        //1단계 -> 회전
        for(int i = 1; i<2*N; i++){
            A_copy[i+1] = A[i];
            if(i < N){
                B_copy[i+1] = B[i];
                if(i+1 == N) B_copy[N] = false;
            }
        }
        A_copy[1] = A[2*N];
        B_copy[1] = false;

        //2단계 -> 로봇 이동
        for(int i = N-1; i>1; i--){
            if(B_copy[i]){
                if(B_copy[i+1] || A_copy[i+1] == 0) continue; // 로봇이 있거나 내구도 0이면 이동X

                B_copy[i] = false;
                B_copy[i+1] = true;
                A_copy[i+1]--;
                if(A_copy[i+1] == 0) zero++;
                if(i+1 == N){ // N위치에 와서 내리기
                    B_copy[i+1] = false;
                }

            }
        }


        //3단계 -> 로봇 올리기
        if(A_copy[1] > 0){
            A_copy[1]--;
            B_copy[1] = true;

            if(A_copy[1] == 0) zero++;
        }

        A = A_copy;
        B = B_copy;

        // 4단계
        return zero < K;
    }
}