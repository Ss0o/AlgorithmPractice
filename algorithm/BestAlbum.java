package algorithm;

import java.util.*;

class Solution_BestAlbum {
    class Song {
        int index;
        int play;
        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>(); // 장르별로 총 재생 수 저장
        Map<String, List<Song>> genreSongs = new HashMap<>(); // 장르별로 노래들 저장

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);

            genreSongs
                    .computeIfAbsent(genre, k -> new ArrayList<>())
                    .add(new Song(i, play));
        }
        List<String> genreOrder = new ArrayList<>(genreSongs.keySet());
        genreOrder.sort((g1, g2) -> {
            return Integer.compare(genreTotal.get(g2), genreTotal.get(g1));
        });

        List<Integer> answer = new ArrayList<>();

        for(String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);

            // song들 재생수 내림차 정렬, 근데 재생 수 같으면 고유번호 순서로 정렬
            songs.sort((s1, s2) -> {
                if(s1.play != s2.play) {
                    return s2.play - s1.play;
                }
                else {
                    return s1.index - s2.index;
                }
            });
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).index);
            }

        }
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }


        return result;

    }
}

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution_BestAlbum solution = new Solution_BestAlbum();
        int[] result = solution.solution(genres, plays);

        System.out.println(Arrays.toString(result)); // [4, 1, 3, 0]
    }
}
