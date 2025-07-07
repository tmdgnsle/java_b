import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video_len_hour = Integer.parseInt(video_len.substring(0,2));
        int video_len_min = Integer.parseInt(video_len.substring(3, 5));
        
        int pos_hour = Integer.parseInt(pos.substring(0,2));
        int pos_min = Integer.parseInt(pos.substring(3, 5));
        
        int op_start_hour = Integer.parseInt(op_start.substring(0,2));
        int op_start_min = Integer.parseInt(op_start.substring(3,5));
        
        int op_end_hour = Integer.parseInt(op_end.substring(0,2));
        int op_end_min = Integer.parseInt(op_end.substring(3,5));
        
        
        if(pos_hour > op_start_hour && pos_hour < op_end_hour){
                pos_hour = op_end_hour;
                pos_min = op_end_min;
            }else if(pos_hour == op_start_hour && pos_hour == op_end_hour){
    if(pos_min >= op_start_min && pos_min <= op_end_min){
        pos_hour = op_end_hour;
        pos_min = op_end_min;
    }
}else if(pos_hour == op_start_hour){
                if(pos_min >= op_start_min){
                    pos_hour = op_end_hour;
                pos_min = op_end_min;
                }
            }else if(pos_hour == op_end_hour){
                if(pos_min < op_end_min){
                    pos_hour = op_end_hour;
                pos_min = op_end_min;
                }
            }
        
        for(String command: commands){
            
            if(command.equals("next")){
                pos_min += 10;
            }else {
                pos_min -= 10;
            }
            
            // 초가 60넘어가거나 마이너스되면 시간단위 변경
            if(pos_min < 0){
                pos_hour -= 1;
                pos_min = 60 + pos_min;
            } else if (pos_min >= 60){
                pos_hour += 1;
                pos_min = pos_min - 60;
            }
            
            
            // 시작 시간보다 작은지 또는 끝나는 시간보다 큰지 체크
            if(pos_hour < 0){
                pos_hour = 0;
                pos_min = 0;
            }else if (pos_hour > video_len_hour){
                pos_hour = video_len_hour;
                pos_min = video_len_min;
            }else if (pos_hour == video_len_hour && pos_min > video_len_min){
                pos_hour = video_len_hour;
                pos_min = video_len_min;
            }
            
            // 오프닝 시간 체크 -> 사이에 있으면 오프닝 엔딩 시간으로 ㄱㄱ
            if(pos_hour > op_start_hour && pos_hour < op_end_hour){
                pos_hour = op_end_hour;
                pos_min = op_end_min;
            }else if(pos_hour == op_start_hour && pos_hour == op_end_hour){
    if(pos_min >= op_start_min && pos_min <= op_end_min){
        pos_hour = op_end_hour;
        pos_min = op_end_min;
    }
}else if(pos_hour == op_start_hour){
                if(pos_min >= op_start_min){
                    pos_hour = op_end_hour;
                pos_min = op_end_min;
                }
            }else if(pos_hour == op_end_hour){
                if(pos_min < op_end_min){
                    pos_hour = op_end_hour;
                pos_min = op_end_min;
                }
            }
            
        }
        
        
        String answer = String.format("%02d:%02d", pos_hour, pos_min);
        return answer;
    }
}