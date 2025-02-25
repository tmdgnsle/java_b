

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] isPrime = new boolean[N + 1];
        
        // 모든 수를 소수로 초기화 (true)
        Arrays.fill(isPrime, true);
        
        // 0과 1은 소수가 아님
        isPrime[0] = isPrime[1] = false;
        
        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                // i의 배수들을 모두 소수가 아님으로 표시
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // M부터 N까지의 소수 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
        
        sc.close();
    }
}