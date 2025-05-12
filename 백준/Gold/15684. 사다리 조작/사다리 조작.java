import java.io.*;
import java.util.*;

public class Main {

    static class Ladder {
        int x;
        int y;

        Ladder(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, H;
    static boolean[][] ladder;
    static int result;
    static ArrayList<Ladder> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N];
        arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            ladder[p1][p2] = true;
            arr.add(new Ladder(p1, p2));
        }

        result = Integer.MAX_VALUE;

        for(int i = 0; i<=3; i++){
            bt(0, i);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void bt(int count, int target) {

        if (count == target) {
            if (simulate()) {
                result = Math.min(result, count);
            }
            return;
        }

        if(result != Integer.MAX_VALUE) return;


        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (ladder[i][j]) continue;

                if (isValid(i, j)) {
                    //인접한 위치 불가능 로직 추가
                    ladder[i][j] = true;
                    arr.add(new Ladder(i, j));
                    bt(count + 1, target);
                    ladder[i][j] = false;
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        for (Ladder l : arr) {
            if (x == l.x) {
                if (Math.abs(l.y - y) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean simulate() {

        int current = 1;
        while (current <= N) {
            int now = current;
            for (int i = 1; i <= H; i++) {
                if (now == 1) {
                    if (ladder[i][now]) {
                        now++;
                    }
                } else if (now == N) {
                    if (ladder[i][now - 1]) {
                        now--;
                    }
                } else {
                    if (ladder[i][now]) {
                        now++;
                    } else if (ladder[i][now - 1]) {
                        now--;
                    }
                }

            }
            if (now == current) {
                current++;
            } else {
                return false;
            }

        }

        return true;
    }

}