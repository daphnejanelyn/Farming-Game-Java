package View;

import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[2];

    public Sound() {
        /* get file path of music assets */
        soundURL[0] = getClass().getResource("/resources/sound/mp-music.wav");
        soundURL[1] = getClass().getResource("/resources/sound/click-sound.wav");
    }

    /* initialize music to program */
    public void setFile(int soundIndex) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundURL[soundIndex]);
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* This method plays the music. */
    public void play() {
        clip.start();
    }

    /* This method loops the music. */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /* This method stops the music. */
    public void stop() {
        clip.stop();
    }
}
