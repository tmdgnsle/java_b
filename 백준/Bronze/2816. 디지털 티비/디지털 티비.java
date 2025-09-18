import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<String> channels = new ArrayList<>();

        // 채널 리스트 입력받기
        for (int i = 0; i < N; i++) {
            channels.add(br.readLine());
        }

        int cursor = 0; // 현재 화살표 위치

        // 1단계: KBS1을 맨 위(0번 인덱스)로 이동
        // KBS1 찾기
        int kbs1Index = -1;
        for (int i = 0; i < channels.size(); i++) {
            if (channels.get(i).equals("KBS1")) {
                kbs1Index = i;
                break;
            }
        }

        // 화살표를 KBS1 위치로 이동 (1번 버튼)
        while (cursor < kbs1Index) {
            result.append("1");
            cursor++;
        }

        // KBS1을 맨 위로 이동 (4번 버튼)
        while (kbs1Index > 0) {
            result.append("4");
            // 채널 리스트에서 실제로 위치 변경
            Collections.swap(channels, kbs1Index, kbs1Index - 1);
            kbs1Index--;
        }

        // 2단계: KBS2를 두 번째(1번 인덱스)로 이동
        // 화살표를 맨 위로 이동 (2번 버튼)
        while (cursor > 0) {
            result.append("2");
            cursor--;
        }

        // KBS2 찾기
        int kbs2Index = -1;
        for (int i = 0; i < channels.size(); i++) {
            if (channels.get(i).equals("KBS2")) {
                kbs2Index = i;
                break;
            }
        }

        // 화살표를 KBS2 위치로 이동 (1번 버튼)
        while (cursor < kbs2Index) {
            result.append("1");
            cursor++;
        }

        // KBS2를 두 번째 위치로 이동 (4번 버튼)
        while (kbs2Index > 1) {
            result.append("4");
            // 채널 리스트에서 실제로 위치 변경
            Collections.swap(channels, kbs2Index, kbs2Index - 1);
            kbs2Index--;
        }

        System.out.println(result);
    }
}