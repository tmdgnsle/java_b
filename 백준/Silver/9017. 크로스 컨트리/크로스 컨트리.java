import java.io.*;
import java.util.*;

public class Main {
    static ArrayList[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int maxNum = 0;
            int N = Integer.parseInt(br.readLine());
            int[] runners = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                runners[i] = team;
                maxNum = Math.max(maxNum, team);
            }
            arr = new ArrayList[maxNum + 1];
            for (int i = 1; i <= maxNum; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            int[] teamCount = new int[maxNum + 1];
            for (int i = 0; i < N; i++) {
                teamCount[runners[i]]++;
            }


            int score = 1;
            for (int i = 0; i < N; i++) {
                int team = runners[i];
                if (teamCount[team] < 6) continue;

                arr[team].add(score++);
            }


            int answerTeam = 0;
            int answerScore = Integer.MAX_VALUE;

            for (int i = 1; i <= maxNum; i++) {
                int team = i;
                int totalScore = 0;
                if (arr[i].size() < 6) continue;

                for (int j = 0; j < 4; j++) {
                    totalScore += (int) arr[i].get(j);
                }


                if (answerScore > totalScore) {
                    answerTeam = team;
                    answerScore = totalScore;

                } else if (answerScore == totalScore) {
                    int first = (int) arr[answerTeam].get(4);
                    int second = (int) arr[team].get(4);

                    if (first > second) {
                        answerTeam = team;
                        answerScore = totalScore;
                    }

                }

            }

            System.out.println(answerTeam);

        }

    }
}