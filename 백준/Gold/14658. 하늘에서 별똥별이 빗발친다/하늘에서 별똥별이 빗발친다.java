import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static ArrayList<Integer> xSet;
    static ArrayList<Integer> ySet;
    static ArrayList<int[]> stars;
    static int tStars;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        xSet = new ArrayList<>();
        ySet = new ArrayList<>();
        stars = new ArrayList<>();

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if(!xSet.contains(p1)) xSet.add(p1);
            if(!ySet.contains(p2)) ySet.add(p2);

            stars.add(new int[] {p1, p2});
        }

        tStars = Integer.MIN_VALUE;

        find();

        System.out.println(K - tStars);

    }


    static void find(){
        for(int i = 0; i<xSet.size(); i++){
            for(int j = 0; j<ySet.size(); j++){
                int x = xSet.get(i);
                int y = ySet.get(j);

                count(x, y);
            }
        }
    }

    static void count(int x, int y){
        int maxX = x + L;
        int maxY = y + L;

        if(maxX > N) maxX = N;
        if(maxY > M) maxY = M;

        int count = 0;

        for(int[] star: stars){
            if(star[0] >= x && star[0] <= maxX && star[1] >= y && star[1] <= maxY) count++;
        }

        tStars = Math.max(tStars, count);
    }
}