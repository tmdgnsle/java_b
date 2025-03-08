import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;     // N: 정수의 개수, S: 목표 합
    static int[] arr;    // 수열을 저장할 배열
    static int count = 0;// 합이 S가 되는 부분수열의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹으로 모든 부분수열을 탐색
        backtrack(0, 0);

        // S가 0인 경우, 공집합도 합이 0이 되므로 count에서 1을 빼야 함
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    // idx: 현재 인덱스, sum: 현재까지의 부분수열 합
    private static void backtrack(int idx, int sum) {
        // 모든 원소를 고려한 경우
        if (idx == N) {
            // 합이 S와 같다면 카운트 증가
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 선택하는 경우
        backtrack(idx + 1, sum + arr[idx]);

        // 현재 원소를 선택하지 않는 경우
        backtrack(idx + 1, sum);
    }
}