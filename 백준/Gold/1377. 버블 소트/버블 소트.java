

import java.util.*;
import java.io.*;


// 버블소트에서는 한번씩 밖에 이동을 안함
// 정렬하기 전 인덱스와 정렬 후 인덱스의 차이는 몇 번 버블 소트를 진행했는지 나타남
// 한 번 더 반복을 돌았을 때 출력이 되므로 +1
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int Max = 0;
        for (int i = 0; i < N; i++) {
            Max = Math.max(Max, A[i].index - i);
        }
        System.out.println(Max+1);
    }

    static class mData implements Comparable<mData>{

        int value;
        int index;

        mData(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }
}
