import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] abilities;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        abilities = new int[N][N];
        selected = new boolean[N];

        // 능력치 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인덱스 0부터 백트래킹 시작
        backtrack(0, 0);

        System.out.println(minDiff);
    }

    static void backtrack(int index, int count) {
        // N/2명의 선수를 선택했다면 차이 계산
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        if (minDiff == 0) return;

        // 끝까지 도달했거나 남은 선수로 팀을 채울 수 없다면 리턴
        if (index >= N) return;

        // 현재 선수를 선택
        selected[index] = true;
        backtrack(index + 1, count + 1);

        // 현재 선수를 선택하지 않음
        selected[index] = false;
        backtrack(index + 1, count);
    }

    static void calculateDifference() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startTeamScore += abilities[i][j];
                } else if (!selected[i] && !selected[j]) {
                    linkTeamScore += abilities[i][j];
                }
            }
        }

        int diff = Math.abs(startTeamScore - linkTeamScore);
        minDiff = Math.min(minDiff, diff);

        // 최적화: 차이가 0이면 더 이상 계산할 필요 없음
        if (minDiff == 0) {
            return;

        }
    }
}