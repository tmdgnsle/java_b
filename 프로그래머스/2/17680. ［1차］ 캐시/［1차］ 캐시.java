import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        HashMap<String, Integer> cache = new HashMap<>();
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(String city: cities){
            city = city.toLowerCase();
            if(cache.containsKey(city)){
                answer += 1;
            } else {
                answer += 5;
                if(cache.size() == cacheSize){
                    int max = 0;
                    String maxKey = "";
                    for(String key: cache.keySet()){
                        if(max < cache.get(key)){
                            max = cache.get(key);
                            maxKey = key;
                        }
                    }
                    cache.remove(maxKey);
                    
                }
            }
            
            for(String key: cache.keySet()){
                cache.put(key, cache.get(key) +1);
            }
            cache.put(city, 1);
            
        }
        
        return answer;
    }
}