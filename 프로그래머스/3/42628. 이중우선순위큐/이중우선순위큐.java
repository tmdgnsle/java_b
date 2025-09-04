import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // TreeMap -> key 오름차순 정렬 자동
        // key: 숫자, value: 해당 숫자의 개수
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                // 삽입 연산
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else if (command.equals("D")) {
                if (map.isEmpty()) continue;
                
                if (number == 1) {
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else if (number == -1) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}