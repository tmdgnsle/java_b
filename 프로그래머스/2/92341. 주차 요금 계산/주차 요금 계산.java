import java.util.*;
class Solution {
    
    static class Time{
        int hour;
        int minute;
        
        public Time(int hour, int minute){
            this.hour = hour;
            this.minute = minute;
        }
    }
    static int basicTime;
    static int basicMoney;
    static int perTime;
    static int perMoney;
    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicMoney = fees[1];
        perTime = fees[2];
        perMoney = fees[3];
        
        HashMap<String, Time> inMap = new HashMap<>();
        TreeMap<Integer, Integer> timeMap = new TreeMap<>();
        
        
        for(String r: records){
            String[] split = r.split(" ");
            String[] time = split[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            String carNumber = split[1];
            String record = split[2];
            
            if(record.equals("IN")){
                inMap.put(carNumber, new Time(hour, minute));
            } else {
                Time inTime = inMap.get(carNumber);
                Time outTime = new Time(hour, minute);
                inMap.remove(carNumber);
                int totalMinutes = calculateTime(inTime, outTime);
                int carNum = Integer.parseInt(carNumber);
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + totalMinutes);
            }
            
        }
        
        for (Map.Entry<String, Time> entry : inMap.entrySet()) {
            String carNumber = entry.getKey();
            Time inTime = entry.getValue();
            Time outTime = new Time(23, 59);
            int totalMinutes = calculateTime(inTime, outTime);
            int carNum = Integer.parseInt(carNumber);
            timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + totalMinutes);
        }
        
        int[] answer = new int[timeMap.entrySet().size()];
        
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : timeMap.entrySet()){
            int totalMinute = entry.getValue();
            int price = calculateMoney(totalMinute);
            answer[idx++] = price;
        }
        
        return answer;
    }
    
    static int calculateTime(Time startTime, Time endTime){
        int beforeHour = startTime.hour;
        int beforeMinute = startTime.minute;
        int afterHour = endTime.hour;
        int afterMinute = endTime.minute;
        
        int minusMinute = 0;
        
        if(afterMinute - beforeMinute < 0){
            minusMinute = afterMinute + (60 - beforeMinute);
            afterHour--;
        } else {
            minusMinute = afterMinute - beforeMinute;
        }
        
        int minusHour = afterHour - beforeHour;
        
        return minusHour * 60 + minusMinute;
        
        
    }
    
    static int calculateMoney(int minute){
        int totalMoney = basicMoney;
        int remainTime = minute - basicTime;
        if(remainTime <= 0){
            return basicMoney;
        }else {
            if(remainTime % perTime > 0){
                remainTime = (remainTime / perTime) + 1;
            }else{
                remainTime = remainTime / perTime;
            }
            
            totalMoney += remainTime * perMoney;
            
        }
        
        return totalMoney;
    }
}