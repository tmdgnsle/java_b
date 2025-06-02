import java.io.*;
import java.util.*;

public class Main {

    static class Jewelry implements Comparable<Jewelry> {
        int m;
        int v;

        Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            return -(this.v - o.v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> j = new PriorityQueue<>();
        TreeMap<Integer, Integer> bags = new TreeMap<>(); // 용량 -> 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            j.add(new Jewelry(m, c));
        }

        for (int i = 0; i < K; i++) {
            int capacity = Integer.parseInt(br.readLine());
            bags.put(capacity, bags.getOrDefault(capacity, 0) + 1);
        }

        long result = 0;
        
        while (!j.isEmpty() && !bags.isEmpty()) {
            Jewelry jew = j.poll();
            
            // 현재 보석의 무게 이상인 가장 작은 용량의 가방 찾기
            Integer suitableBag = bags.ceilingKey(jew.m);
            
            if (suitableBag != null) {
                result += jew.v;
                
                // 가방 개수 감소
                int count = bags.get(suitableBag);
                if (count == 1) {
                    bags.remove(suitableBag);
                } else {
                    bags.put(suitableBag, count - 1);
                }
            }
        }
        
        System.out.println(result);
    }
}