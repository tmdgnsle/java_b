import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> total = new HashMap<>();
        Map<String, ArrayList<Integer>> songs = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {

            total.put(genres[i],
                total.getOrDefault(genres[i], 0) + plays[i]);

            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(i);
        }

        ArrayList<String> genreList = new ArrayList<>(total.keySet());

        genreList.sort((a, b) -> total.get(b) - total.get(a));

        ArrayList<Integer> answer = new ArrayList<>();

        for(String genre : genreList) {

            ArrayList<Integer> list = songs.get(genre);

            list.sort((a, b) -> {
                if(plays[a] == plays[b]) {
                    return a - b;
                }
                return plays[b] - plays[a];
            });

            answer.add(list.get(0));

            if(list.size() >= 2) {
                answer.add(list.get(1));
            }
        }

        int[] result = new int[answer.size()];

        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}