import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n+1][n+1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i == j){
					board[i][j] = 0;
				} else {
					board[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while(true){
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());

			if(p1 == -1 && p2 == -1){
				break;
			}

			board[p1][p2] = 1;
			board[p2][p1] = 1;
		}

		for(int k = 1; k <= n; k++){
			for (int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++){
					if(board[i][k] != Integer.MAX_VALUE && board[k][j] != Integer.MAX_VALUE){
						board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
					}
				}
			}
		}

		int[] scores = new  int[n+1];
		int minScores = Integer.MAX_VALUE;
		for(int i = 1; i<=n; i++){
			int maxDist = 0;
			for(int j = 1; j<=n; j++){
				if(i != j){
					maxDist = Math.max(maxDist, board[i][j]);
				}
			}

			scores[i] = maxDist;
			minScores = Math.min(maxDist, minScores);
		}

		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i<=n; i++){
			if(scores[i] == minScores){
				arr.add(i);
			}
		}

		System.out.println(minScores + " " + arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();

	}
}