package View;

import java.net.URL;
import javax.sound.sampled.*;
// javax.sound.sampled.AudioInput
// javax.sound.sampled.AudioSystem
// javax.sound.sampled.Clip

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[2];

    public Sound() {
        soundURL[0] = getClass().getResource("/resources/sound/mp-music.wav");
        soundURL[1] = getClass().getResource("/resources/sound/click-sound.wav");
    }

    public void setFile(int soundIndex) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundURL[soundIndex]);
            clip = AudioSystem.getClip();
            clip.open(audio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
