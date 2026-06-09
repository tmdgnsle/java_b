class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};
        
        for(String word: babbling){
            int idx = 0;
            String prev = "";
            boolean ok = true;
            
            while(idx < word.length()){
                boolean matched = false;
                
                for(String sound: sounds){
                    if(word.startsWith(sound, idx)){
                        if(sound.equals(prev)){
                            ok = false;
                        }
                        prev = sound;
                        idx += sound.length();
                        matched = true;
                        break;
                    }
                }
                
                if(!matched || !ok){
                    ok = false;
                    break;
                }
            }
            if(ok) answer++;
        }
        
        return answer;
    }
}