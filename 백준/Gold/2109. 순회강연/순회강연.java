import java.io.*;
import java.util.*;


public class Main {

	static class Lecture implements Comparable<Lecture> {
		private int d;
		private int p;

		Lecture(int d, int p){
			this.d = d;
			this.p = p;
		}

		@Override
		public int compareTo(Lecture o) {
			return -(this.p - o.p);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
		int maxD = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if(d > maxD){
				maxD = d;
			}
			pq.add(new Lecture(d, p));
		}

		boolean[] v = new boolean[maxD+1];
		int result = 0;
		while(!pq.isEmpty()){
			Lecture l = pq.poll();
			for(int i = l.d; i>=1; i--){
				if(!v[i]){
					v[i] = true;
					result += l.p;
					break;
				}
			}

		}

		System.out.println(result);

	}

}