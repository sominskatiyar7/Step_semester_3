import java.util.Arrays;

class Songs {
    private String[] songs;
    private int count;

    Songs(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Playlist {
    public static void main(String[] args) {

        Songs p = new Songs(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("Playlist:");
        System.out.println(Arrays.toString(p.getSongs()));

        System.out.println("Song count: " + p.getSongCount());
    }
}