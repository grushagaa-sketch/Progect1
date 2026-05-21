package lab2_13;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//Создать программу будильник время срабатывания брать из файла


public class MainTaskTimer {
    public static void main(String[] args) throws ParseException, IOException {




        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("подъем");

                try {
                    AudioInputStream audioStream =
                            AudioSystem.getAudioInputStream(new File("Вставай-с-первыми-лучами-вставай-_muzeye.net_.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                    //clip.stop();
                    Thread.sleep(clip.getMicrosecondLength() / 1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer();
        //timer.schedule(task, 3000);

        String txt = Files.readString(Path.of("будильник.txt"));
        Date time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .parse(txt);

        timer.schedule(task, time);
        //timer.cancel();
    }

}
