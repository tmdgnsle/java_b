import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        
        Map<String, Integer> map1 = makeMultiSet(str1);
        Map<String, Integer> map2 = makeMultiSet(str2);

        
        int intersection = 0;
        int union = 0;

        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);

            intersection += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }

        
        if (union == 0) {
            return 65536;
        }

        
        double jaccard = (double) intersection / union;
        return (int) (jaccard * 65536);
    }

    
    private Map<String, Integer> makeMultiSet(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String key = "" + c1 + c2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        return map;
    }
}