import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < testCases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
			int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

			// 대기열 및 우선순위 입력 받기
			st = new StringTokenizer(br.readLine());
			Queue<Document> queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.offer(new Document(i, priority));
			}

			int count = 0; // 인쇄 순서 카운트

			while (!queue.isEmpty()) {
				Document current = queue.poll();
				boolean isMax = true;

				// 현재 문서보다 중요도가 높은 문서가 있는지 확인
				for (Document doc : queue) {
					if (doc.priority > current.priority) {
						isMax = false;
						break;
					}
				}

				if (isMax) { // 현재 문서가 가장 중요도가 높음
					count++;
					if (current.index == m) { // 궁금한 문서라면
						sb.append(count).append('\n');
						break;
					}
				} else { // 더 중요한 문서가 있으면 뒤로 보냄
					queue.offer(current);
				}
			}
		}

		System.out.print(sb);
	}

	static class Document {
		int index; // 문서 원래 위치
		int priority; // 문서 중요도

		Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
}