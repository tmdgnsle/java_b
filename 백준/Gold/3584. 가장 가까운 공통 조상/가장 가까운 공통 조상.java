import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[] depth;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			parent = new int[N + 1];
			depth = new int[N + 1];
			visited = new boolean[N + 1];

			// 부모 관계 입력
			for(int i = 0; i < N - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a; // b의 부모는 a
			}

			// 루트 노드 찾기 (부모가 없는 노드)
			int root = 0;
			for(int i = 1; i <= N; i++) {
				if(parent[i] == 0) {
					root = i;
					break;
				}
			}

			// 각 노드의 깊이 계산
			calculateDepth(root, 0);

			// LCA를 구할 두 노드 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// LCA 계산 및 출력
			System.out.println(findLCA(u, v));
		}
	}

	// DFS로 각 노드의 깊이 계산
	static void calculateDepth(int node, int d) {
		depth[node] = d;
		visited[node] = true;

		// 자식 노드들의 깊이 계산
		for(int i = 1; i < parent.length; i++) {
			if(!visited[i] && parent[i] == node) {
				calculateDepth(i, d + 1);
			}
		}
	}

	// 두 노드의 LCA 찾기
	static int findLCA(int u, int v) {
		// 더 깊은 노드를 같은 깊이까지 올려보내기
		while(depth[u] > depth[v]) {
			u = parent[u];
		}
		while(depth[v] > depth[u]) {
			v = parent[v];
		}

		// 같은 조상을 만날 때까지 동시에 올라가기
		while(u != v) {
			u = parent[u];
			v = parent[v];
		}

		return u;
	}
}