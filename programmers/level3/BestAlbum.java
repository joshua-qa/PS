import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap();
        for (int i = 0; i < genres.length; i++) {
            Genre genre = genreMap.containsKey(genres[i]) ? genreMap.get(genres[i]) : new Genre(0);
            genre.count += plays[i];
            genre.songList.offer(new Song(plays[i], i));
            genreMap.put(genres[i], genre);
        }
        Queue<Genre> genreList = new PriorityQueue(genreMap.values());
        List<Integer> bestAlbum = new ArrayList<>();
        while (!genreList.isEmpty()) {
            Genre currentGenre = genreList.poll();
            int albumSize = currentGenre.songList.size() == 1 ? 1 : 2;
            for (int i = 0; i < albumSize; i++) {
                bestAlbum.add(currentGenre.songList.poll().index);
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }

    class Genre implements Comparable<Genre> {
        int count;
        Queue<Song> songList;

        public Genre(int count) {
            this.count = count;
            this.songList = new PriorityQueue<>();
        }

        @Override
        public int compareTo(Genre o) {
            return o.count - this.count;
        }
    }

    class Song implements Comparable<Song> {
        int plays;
        int index;

        public Song(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }

        @Override
        public int compareTo(Song o) {
            if (o.plays == this.plays) {
                return this.index - o.index;
            }
            return o.plays - this.plays;
        }
    }
}