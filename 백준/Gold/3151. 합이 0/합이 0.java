import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 - 투 포인터를 사용하기 위함
        Arrays.sort(arr);

        long answer = 0;

        // 첫 번째 수를 고정
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    // 합이 0인 경우

                    if (arr[left] == arr[right]) {
                        // left와 right 사이의 모든 값이 같은 경우
                        // nC2 = n(n-1)/2 공식 사용
                        int count = right - left + 1;
                        answer += (long) count * (count - 1) / 2;
                        break;
                    } else {
                        // left 값과 같은 개수 세기
                        int leftCount = 1;
                        while (left + leftCount < right && arr[left] == arr[left + leftCount]) {
                            leftCount++;
                        }

                        // right 값과 같은 개수 세기
                        int rightCount = 1;
                        while (right - rightCount > left && arr[right] == arr[right - rightCount]) {
                            rightCount++;
                        }

                        // 경우의 수 = leftCount * rightCount
                        answer += (long) leftCount * rightCount;

                        // 포인터 이동
                        left += leftCount;
                        right -= rightCount;
                    }
                } else if (sum < 0) {
                    // 합이 0보다 작으면 left 증가
                    left++;
                } else {
                    // 합이 0보다 크면 right 감소
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}