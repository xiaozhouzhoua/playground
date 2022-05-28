package com.some.playground.funs;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class PlayMusicDemo implements LineListener {

    boolean isPlaybackCompleted;

    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            System.out.println("Playback started.");
        } else if (LineEvent.Type.STOP == event.getType()) {
            isPlaybackCompleted = true;
            System.out.println("Playback completed.");
        }
    }

    void play(String audioFilePath) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();
            while (!isPlaybackCompleted) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioClip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println("Error occurred during playback process:"+ ex.getMessage());
        }

    }

    public static void main(String[] args) {
        String audioFilePath = "AudioFileWithWavFormat.wav";

        // Clip can not play mpeg/mp3 format audio. We'll get exception if we run with below commented mp3 and mpeg format audio.
        // String audioFilePath = "AudioFileWithMpegFormat.mpeg";
        // String audioFilePath = "AudioFileWithMp3Format.mp3";

        PlayMusicDemo player = new PlayMusicDemo();
        player.play(audioFilePath);
    }
}
