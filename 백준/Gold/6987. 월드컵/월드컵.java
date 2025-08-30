import java.io.*;
import java.util.*;

public class Main {

	static class Team{
		int win;
		int draw;
		int lose;

		public Team(int win, int draw, int lose){
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
	}

	static int[][] matches; // 경기 조합을 저장할 배열
	static Team[] teams;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] answer = new int[4];

		// 경기 조합 미리 생성 (0vs1, 0vs2, ..., 4vs5 총 15경기)
		matches = new int[15][2];
		int idx = 0;
		for(int i = 0; i < 6; i++){
			for(int j = i + 1; j < 6; j++){
				matches[idx][0] = i;
				matches[idx][1] = j;
				idx++;
			}
		}

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			teams = new Team[6];
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				teams[j] = new Team(win, draw, lose);
			}

			answer[i] = solve();
		}

		for(int a: answer){
			System.out.print(a + " ");
		}
		System.out.println();
	}

	static int solve(){
		// 기본 조건 체크
		int totalWin = 0;
		int totalLose = 0;
		int totalDraw = 0;

		for(Team team: teams){
			int teamTotal = team.win + team.draw + team.lose;
			totalWin += team.win;
			totalLose += team.lose;
			totalDraw += team.draw;
			if(teamTotal != 5) return 0; // 각 팀은 5경기
		}

		if(totalWin != totalLose) return 0; // 승수와 패수는 같아야 함
		if(totalDraw % 2 != 0) return 0;   // 무승부는 짝수여야 함

		// 실제 경기 결과 시뮬레이션
		return backtrack(0) ? 1 : 0;
	}

	static boolean backtrack(int matchIdx){
		if(matchIdx == 15){
			// 모든 경기가 끝났을 때 모든 팀의 승/무/패가 0인지 확인
			for(Team team : teams){
				if(team.win != 0 || team.draw != 0 || team.lose != 0){
					return false;
				}
			}
			return true;
		}

		int team1 = matches[matchIdx][0];
		int team2 = matches[matchIdx][1];

		// 경우 1: team1 승, team2 패
		if(teams[team1].win > 0 && teams[team2].lose > 0){
			teams[team1].win--;
			teams[team2].lose--;
			if(backtrack(matchIdx + 1)) return true;
			teams[team1].win++;
			teams[team2].lose++;
		}

		// 경우 2: team1 패, team2 승
		if(teams[team1].lose > 0 && teams[team2].win > 0){
			teams[team1].lose--;
			teams[team2].win--;
			if(backtrack(matchIdx + 1)) return true;
			teams[team1].lose++;
			teams[team2].win++;
		}

		// 경우 3: 무승부
		if(teams[team1].draw > 0 && teams[team2].draw > 0){
			teams[team1].draw--;
			teams[team2].draw--;
			if(backtrack(matchIdx + 1)) return true;
			teams[team1].draw++;
			teams[team2].draw++;
		}

		return false;
	}
}