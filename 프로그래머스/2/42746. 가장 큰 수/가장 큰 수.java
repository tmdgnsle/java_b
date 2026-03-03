import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // b+a 가 더 크면 -> b가 앞에
        // a+b 가 더 크면 -> a가 앞에
        
        // 0 처리
        if(arr[0].equals("0")) return "0";
        
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        
        return sb.toString();
    }
}