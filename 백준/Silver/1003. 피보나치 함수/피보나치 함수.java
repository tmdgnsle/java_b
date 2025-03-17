import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] Dz = new int[41];
		int[] Do = new int[41];

		Dz[0] = 1;
		Dz[1] = 0;
		Do[0] = 0;
		Do[1] = 1;

		for (int i = 2; i <= 40; i++) {
			Dz[i] = Dz[i - 1] + Dz[i - 2];
			Do[i] = Do[i - 1] + Do[i - 2];
		}

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.println(Dz[N] + " " + Do[N]);
		}
	}
}