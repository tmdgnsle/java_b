import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] D = new int[11];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for (int i = 4; i <= 10; i++) {
			D[i] = D[i - 1] + D[i - 2] + D[i - 3];
		}
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.println(D[N]);
		}
	}
}