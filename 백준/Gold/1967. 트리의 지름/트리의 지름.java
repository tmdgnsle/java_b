import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int p;
        int w;

        public Node(int p, int w){
            this.p = p;
            this.w = w;
        }
    }

    static int n;
    static ArrayList<Node>[] arrs;
    static boolean[] v;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrs = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            arrs[i] = new ArrayList<>();
        }




        answer = 0;
        StringTokenizer st;
        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arrs[p1].add(new Node(p2, w));
            arrs[p2].add(new Node(p1, w));
        }



        for(int i = 1; i<=n; i++){
            v = new boolean[n+1];
            dfs(i, i, 0);
        }


        System.out.println(answer);
    }

    static void dfs(int start,int current, int count){
        v[current] = true;
        for(Node n: arrs[current]){
            int p = n.p;
            int w = n.w;

            if(!v[p]){
                int distance = count + w;
                answer = Math.max(answer, distance);
                dfs(start, p, distance);
            }

        }
    }
}