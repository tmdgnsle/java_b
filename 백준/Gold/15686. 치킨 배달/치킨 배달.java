import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Point> house;
    static ArrayList<Point> chickens;
    static int result = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getDistance(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    house.add(new Point(i, j));
                }
                if (val == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        boolean[] v = new boolean[chickens.size()];
        combi(0, 0, v);

        System.out.println(result);

    }

    static void combi(int start, int depth, boolean[] v) {
        if (depth == M) {
            calDistance(v);
            return;
        } else {
            for (int i = start; i < chickens.size(); i++) {
                if (!v[i]) {
                    v[i] = true;
                    combi(i, depth + 1, v);
                    v[i] = false;
                }
            }
        }
    }

    static void calDistance(boolean[] v) {
        int totalDistance = 0;
        for (Point p : house) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (v[i]) {
                    int distance = p.getDistance(chickens.get(i));
                    minDistance = Math.min(minDistance, distance);
                }
            }
            totalDistance += minDistance;
        }
        result = Math.min(result, totalDistance);
    }

}