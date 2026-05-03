import java.util.*;
import java.io.*;
public class Main {

    static class Hospital{
        int x;
        int y;

        Hospital(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Person{
        int x;
        int y;

        Person(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Person> people;
    static ArrayList<Hospital> hospitals;
    static int n;
    static int m;
    static ArrayList<Hospital> mHospital;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        people = new ArrayList<>();
        hospitals = new ArrayList<>();
        mHospital = new ArrayList<>();

        int[][] map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    people.add(new Person(i, j));
                }else if(num == 2){
                    hospitals.add(new Hospital(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(answer);

        // 병원과 사람들 좌표 저장
        // 병원들 중 m개만큼 후보 만들기
        // 사람들하고 거리 계산(단순 반복 계산으로)
        // 정답보다 커지면 return
        
    }

    static void dfs(int idx){
        if(mHospital.size() == m){
            getDistance();
            return;
        }

        for(int i = idx; i<hospitals.size(); i++){
            mHospital.add(hospitals.get(i));
            dfs(i+1);
            mHospital.remove(mHospital.size() - 1);
        }

    }

    static void getDistance(){
        int totalDistance = 0;
        for(int i = 0; i<people.size(); i++){
            int min = Integer.MAX_VALUE;
            Person p = people.get(i);
            for(int j = 0; j<mHospital.size(); j++){
                Hospital h = mHospital.get(j);
                int distance = Math.abs(p.x - h.x) + Math.abs(p.y - h.y);
                min = Math.min(min, distance);
            }
            totalDistance += min;
        }

        answer = Math.min(answer, totalDistance);

    }

}