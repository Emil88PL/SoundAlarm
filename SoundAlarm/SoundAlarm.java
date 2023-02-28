import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;

public class SoundAlarm {

  public static void main(String[] args) throws InterruptedException {
    
    Timer timer = new Timer();
    timer.schedule(new SoundTask(), 0, 20 * 60 * 1000); // Schedule the task to run every 30 minutes
    Thread.sleep(Long.MAX_VALUE); // Keep the main thread running indefinitely
    
  }

  static class SoundTask extends TimerTask {
    
    @Override
    public void run() {
      try {
        // Load the sound file
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("file.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        // Play the sound
        clip.start();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}