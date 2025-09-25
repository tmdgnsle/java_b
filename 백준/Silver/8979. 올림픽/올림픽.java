import java.io.*;
import java.util.*;

public class Main {

    static class Country implements Comparable<Country> {
        int country;
        int gold;
        int silver;
        int bronze;

        public Country(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return -(this.bronze - o.bronze);
                }
                return -(this.silver - o.silver);
            }
            return -(this.gold - o.gold);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Country> pq = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            pq.offer(new Country(start, gold, silver, bronze));
        }

        Country before = new Country(0, 0, 0, 0);
        int grade = 1;
        int beforeGrade = 1;
        ArrayList<Country>[] arrs = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            arrs[i] = new ArrayList<>();
        }
        while(!pq.isEmpty()){
            Country current = pq.poll();
            if(before.gold == current.gold && before.silver == current.silver && before.bronze == current.bronze){
                arrs[beforeGrade].add(current);
                if(current.country == K){
                    System.out.println(beforeGrade);
                    break;
                }
            }else {
                arrs[grade].add(current);
                beforeGrade = grade;
                if(current.country == K){
                    System.out.println(grade);
                    break;
                }
            }



            grade++;
            before = current;
        }

    }
}