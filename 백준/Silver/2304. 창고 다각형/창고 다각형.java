import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int L;
        int H;

        Node(int L, int H){
            this.L = L;
            this.H = H;
        }

        @Override
        public int compareTo(Node o){
            return this.L - o.L;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(l, h);
        }

        Arrays.sort(nodes);

        int maxIdx = 0;
        int maxHeight = 0;
        for(int i = 0; i<N; i++){
            if(nodes[i].H > maxHeight){
                maxHeight = nodes[i].H;
                maxIdx = i;
            }
        }

        int currentLeft = 0;
        int beforeX = -1;
        int answer = 0;
        for(int i = 0; i<=maxIdx; i++){
            int currentH = nodes[i].H;
            int currentL = nodes[i].L;

            if(currentH < currentLeft) continue;

            answer += (currentL - beforeX) * currentLeft;

            currentLeft = currentH;
            beforeX = currentL;
        }

        int currnetRight = 0;
        beforeX = -1;
        for(int i = N-1; i>=maxIdx; i--){
            int currentH = nodes[i].H;
            int currentL = nodes[i].L;

            if(currentH < currnetRight) continue;

            answer += (beforeX - currentL) * currnetRight;


            currnetRight = currentH;
            beforeX = currentL;
        }

        answer += maxHeight;

        System.out.println(answer);




    }
}