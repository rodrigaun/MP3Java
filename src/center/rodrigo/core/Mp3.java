package center.rodrigo.core;

import java.io.File;
import java.net.URL;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.Time;

public class Mp3 extends Thread {

    private URL url;
    private MediaLocator mediaLocator;
    private Player playMP3;
    
    public Mp3(String path) {

        try {
            File file = new File(path);
            this.url = file.toURI().toURL();
            mediaLocator = new MediaLocator(url);
            playMP3 = Manager.createPlayer(mediaLocator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        playMP3.addControllerListener(new ControllerListener() {
            public void controllerUpdate(ControllerEvent e) {
                if (e instanceof EndOfMediaEvent) {
                    System.exit(0);
                }
            }
        });
    }

    public void run() {
        try {
            System.out.println("Play");
            playMP3.start();
            this.sleep(5000);
            playMP3.stop();
            System.out.println("Pausado em: " + playMP3.getMediaTime().getSeconds()+ "s");
            this.sleep(5000);
            System.out.println("Play");
            playMP3.start();
            this.sleep(5000);
            playMP3.setMediaTime(new Time(60d));
            System.out.println("Pulou para: " + (int)playMP3.getMediaTime().getSeconds() + "s");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
