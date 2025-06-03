import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class People implements Comparable<People>{
        int idx;
        int age;
        String name;

        People(int idx, int age, String name){
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o){
            if(this.age == o.age){
                return this.idx - o.idx;
            }
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        People[] people = new People[n];
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i-1] = new People(i, age, name);
        }

        Arrays.sort(people);

        for(int i = 0; i<n; i++){
            System.out.println(people[i].age + " " + people[i].name);
        }
        
        
    }
    
}