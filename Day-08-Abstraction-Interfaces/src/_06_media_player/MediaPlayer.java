package _06_media_player;

// Playable interface
interface Playable {
    void play();
    void pause();
    void stop();
}

// Downloadable interface
interface Downloadable {
    void download();
    double getFileSize();
}

// Abstract Media class
abstract class Media {
    String title;
    String artist;
    int duration;   // in seconds

    Media(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration / 60 + ":" + duration % 60);
    }
}

// Audio class
class Audio extends Media implements Playable, Downloadable {
    String format;  // MP3, WAV, etc.

    Audio(String title, String artist, int duration, String format) {
        super(title, artist, duration);
        this.format = format;
    }

    @Override
    public void play() {
        System.out.println("Playing audio: " + title + " by " + artist);
    }

    @Override
    public void pause() {
        System.out.println("Audio paused");
    }

    @Override
    public void stop() {
        System.out.println("Audio stopped");
    }

    @Override
    public void download() {
        System.out.println("Downloading " + title + "." + format);
    }

    @Override
    public double getFileSize() {
        return duration * 0.125;    // Approx 128 kbps
    }
}

// Video class
class Video extends Media implements Playable, Downloadable {
    String resolution;

    Video(String title, String artist, int duration, String resolution) {
        super(title, artist, duration);
        this.resolution = resolution;
    }


    @Override
    public void play() {
        System.out.println("Playing video: " + title + " (" + resolution + ")");
    }

    @Override
    public void pause() {
        System.out.println("Video paused");
    }

    @Override
    public void stop() {
        System.out.println("Video stopped");
    }

    @Override
    public void download() {
        System.out.println("Downloading " + title + " in " + resolution);
    }

    @Override
    public double getFileSize() {
        return duration * 2.0;  // Larger file size for video
    }
}

// Livestream class (playable but not downloadable)
class Livestream extends Media implements Playable {
    String streamUrl;

    Livestream(String title, String artist, String streamUrl) {
        super(title, artist, 0);    // Duration unknown for live
        this.streamUrl = streamUrl;
    }

    @Override
    public void play() {
        System.out.println("Streaming live: " + title);
        System.out.println("URL: " + streamUrl);
    }

    @Override
    public void pause() {
        System.out.println("Cannot pause livestream");
    }

    @Override
    public void stop() {
        System.out.println("Stopped watching livestream");
    }
}

public class MediaPlayer {
    public static void main(String[] args) {
        Audio song = new Audio("Shape of You", "Ed Sheeran", 240, "MP3");
        Video clip = new Video("Despacito", "Luis Fonsi", 280, "1080p");
        Livestream live = new Livestream("Concert", "Coldplay", "http://stream.example.com");

        System.out.println("=== Audio ===");
        song.displayInfo();
        song.play();
        song.download();
        System.out.println("File size: " + song.getFileSize() + " MB");
        song.stop();

        System.out.println("\n=== Video ===");
        clip.displayInfo();
        clip.play();
        clip.download();
        System.out.println("File size: " + clip.getFileSize() + " MB");
        clip.stop();

        System.out.println("\n=== Livestream ===");
        live.displayInfo();
        live.play();
        live.pause();
        live.stop();
    }
}
