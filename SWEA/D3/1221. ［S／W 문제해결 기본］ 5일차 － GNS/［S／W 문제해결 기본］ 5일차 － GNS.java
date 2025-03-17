import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_1221.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			String testCase = sc.next(); // #테스트케이스 번호
			int N = sc.nextInt(); // 문자열의 길이

			// 숫자를 문자로 나타내는 배열
			String[] numStr = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

			// 각 문자열이 나타내는 숫자값을 저장하는 HashMap
			HashMap<String, Integer> numMap = new HashMap<>();
			for (int i = 0; i < 10; i++) {
				numMap.put(numStr[i], i);
			}

			// 입력받은 문자열 배열
			String[] inputArr = new String[N];
			for (int i = 0; i < N; i++) {
				inputArr[i] = sc.next();
			}

			// 카운팅 정렬 방식으로 각 숫자의 개수를 세기
			int[] count = new int[10];
			for (int i = 0; i < N; i++) {
				count[numMap.get(inputArr[i])]++;
			}

			// 결과 출력
			System.out.println(testCase);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < count[i]; j++) {
					System.out.print(numStr[i] + " ");
				}
			}
			System.out.println();
		}

		sc.close();
	}
}