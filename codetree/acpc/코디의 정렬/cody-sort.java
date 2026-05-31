import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        long value;
        int idx;

        Node(long value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        public int compareTo(Node o) {
            if (this.value != o.value) {
                return Long.compare(this.value, o.value);
            }
            return this.idx - o.idx;
        }
    }

    static int N, P;
    static long[] A;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        A = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int s = 1;

        for (int i = 2; i <= N - 1; i++) {
            if (isCandidate(i, s)) {
                pq.offer(new Node(A[i], i));
            }
        }

        for (int turn = 0; turn < P; turn++) {

            while (!pq.isEmpty()) {
                Node cur = pq.peek();

                if (cur.value == A[cur.idx] && isCandidate(cur.idx, s)) {
                    break;
                }

                pq.poll();
            }

            if (!pq.isEmpty()) {
                Node cur = pq.poll();
                int k = cur.idx;

                long temp = A[s];
                A[s] = A[k];
                A[k] = temp;

                addAround(s, s);
                addAround(k, s);
            }

            s++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(' ');
        }

        System.out.println(sb);
    }

    static boolean isCandidate(int idx, int s) {
        if (idx < s + 1 || idx > N - 1) return false;

        return A[idx - 1] > A[idx] && A[idx + 1] > A[idx];
    }

    static void addAround(int idx, int s) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 2 && i <= N - 1 && isCandidate(i, s)) {
                pq.offer(new Node(A[i], i));
            }
        }
    }
}