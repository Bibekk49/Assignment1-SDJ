import javafx.application.Application;
import javafx.application.Platform;

public class RunVinylApp {
  public static void main(String[] args) {
    // Launch the JavaFX application
    Application.launch(VinylApp.class);

    // Create and start a background thread
    Runnable backgroundTask = () -> {
      // Code to be executed in the background thread
      while (true) {
        // Simulate some background work
        System.out.println("Background thread is running...");
        try {
          Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Thread backgroundThread = new Thread(backgroundTask);
    backgroundThread.setDaemon(true); // Set the thread as a daemon (will terminate when the main thread exits)
    backgroundThread.start();

    // The main thread continues to execute other tasks
    System.out.println("Main thread continues...");
  }
}
