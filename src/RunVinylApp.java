import model.util.Threads.VinylActionThreads;
import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import model.VinylModel;

public class RunVinylApp extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory, primaryStage);

    // Open the main view
    viewHandler.start();

    // Start the VinylActionThreads with the VinylModel
    VinylModel vinylModel = modelFactory.getModel();
    VinylActionThreads bobThread = new VinylActionThreads(vinylModel, "Bob");
    VinylActionThreads wendyThread = new VinylActionThreads(vinylModel, "Wendy");

    bobThread.start();
    wendyThread.start();
  }
}
