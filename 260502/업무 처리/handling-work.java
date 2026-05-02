import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int K = sc.nextInt();
        int R = sc.nextInt();

        int leafCount = (int) Math.pow(2, H);

        int leafStart = leafCount;
        int totalNode = leafCount * 2 - 1;

        Queue<Integer>[][] work = new LinkedList[totalNode + 1][2];

        for (int i = 1; i <= totalNode; i++) {
            work[i][0] = new LinkedList<>();
            work[i][1] = new LinkedList<>();
        }

        Queue<Integer>[] leafWork = new LinkedList[totalNode + 1];

        for (int i = 0; i < leafCount; i++) {
            int nodeNum = leafStart + i;
            leafWork[nodeNum] = new LinkedList<>();

            for (int j = 0; j < K; j++) {
                int task = sc.nextInt();
                leafWork[nodeNum].add(task);
            }
        }

        long answer = 0;

        for (int day = 1; day <= R; day++) {
            int dir = day % 2 == 1 ? 0 : 1;

            if (!work[1][dir].isEmpty()) {
                answer += work[1][dir].poll();
            }

            for (int i = 2; i < leafStart; i++) {
                if (!work[i][dir].isEmpty()) {
                    int task = work[i][dir].poll();

                    int parent = i / 2;
                    int childDir = i % 2 == 0 ? 0 : 1;

                    work[parent][childDir].add(task);
                }
            }

            for (int i = 0; i < leafCount; i++) {
                int nodeNum = leafStart + i;

                if (!leafWork[nodeNum].isEmpty()) {
                    int task = leafWork[nodeNum].poll();

                    int parent = nodeNum / 2;
                    int childDir = nodeNum % 2 == 0 ? 0 : 1;

                    work[parent][childDir].add(task);
                }
            }
        }

        System.out.println(answer);
    }
}