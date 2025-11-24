import java.io.*;
import java.util.*;

public class Main {

    static Person[] p;

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new Person[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            p[i] = new Person(p1, p2);
        }

        int[] grades = new int[N];
        for (int i = 0; i < N; i++) {
            int grade = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (p[i].weight < p[j].weight && p[i].height < p[j].height) grade++;
            }
            grades[i] = grade;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(grades[i] + " ");
        }

    }
}