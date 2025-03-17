import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1216.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) { // 10개의 테스트 케이스
			int testCase = sc.nextInt();

			// 100x100 크기의 문자열 배열 입력
			char[][] grid = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String line = sc.next();
				for (int j = 0; j < 100; j++) {
					grid[i][j] = line.charAt(j);
				}
			}

			int maxPalindromeLength = 0;

			// 가로 방향 회문 검사
			for (int i = 0; i < 100; i++) {
				for (int length = 100; length > 0; length--) {
					if (length <= maxPalindromeLength)
						break; // 이미 찾은 최대 길이보다 작으면 검사 중단

					for (int j = 0; j <= 100 - length; j++) {
						if (isPalindrome(grid, i, j, length, true)) {
							maxPalindromeLength = Math.max(maxPalindromeLength, length);
							break; // 현재 행에서 최대 길이 회문을 찾았으면 다음 행으로
						}
					}
				}
			}

			// 세로 방향 회문 검사
			for (int j = 0; j < 100; j++) {
				for (int length = 100; length > 0; length--) {
					if (length <= maxPalindromeLength)
						break; // 이미 찾은 최대 길이보다 작으면 검사 중단

					for (int i = 0; i <= 100 - length; i++) {
						if (isPalindrome(grid, i, j, length, false)) {
							maxPalindromeLength = Math.max(maxPalindromeLength, length);
							break; // 현재 열에서 최대 길이 회문을 찾았으면 다음 열로
						}
					}
				}
			}

			System.out.println("#" + testCase + " " + maxPalindromeLength);
		}

		sc.close();
	}

	// 회문 판별 함수
	public static boolean isPalindrome(char[][] grid, int startRow, int startCol, int length, boolean isHorizontal) {
		for (int k = 0; k < length / 2; k++) {
			char start, end;

			if (isHorizontal) {
				start = grid[startRow][startCol + k];
				end = grid[startRow][startCol + length - 1 - k];
			} else {
				start = grid[startRow + k][startCol];
				end = grid[startRow + length - 1 - k][startCol];
			}

			if (start != end) {
				return false;
			}
		}

		return true;
	}
}