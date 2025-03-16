import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] population;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        selected = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        subset(1);

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);

    }


    static void subset(int idx) {
        if (idx > N) {
            boolean teamA = false;
            boolean teamB = false;
            for (int i = 1; i <= N; i++) {
                if (selected[i])
                    teamA = true;
                else teamB = true;
            }

            if (teamA && teamB) {
                if (isConnected()) {
                    calculateDifference();
                }
            }

            return;
        }
        selected[idx] = true;
        subset(idx + 1);
        selected[idx] = false;
        subset(idx + 1);
    }

    static void calculateDifference() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                teamA += population[i];
            } else {
                teamB += population[i];
            }
        }

        int diff = Math.abs(teamA - teamB);
        minDiff = Math.min(minDiff, diff);

    }

    static boolean isConnected() {
        boolean[] v = new boolean[N + 1];
        int startA = -1;
        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                startA = i;
                break;
            }
        }

        int startB = -1;
        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                startB = i;
                break;
            }
        }

        if (startA == -1 || startB == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startA);
        v[startA] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!v[next] && selected[next]) {
                    queue.add(next);
                    v[next] = true;
                }
            }
        }

        queue.add(startB);
        v[startB] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!v[next] && !selected[next]) {
                    queue.add(next);
                    v[next] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!v[i]) return false;
        }


        return true;


    }
}