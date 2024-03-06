import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class VinylApp extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

    ViewHandler viewHandler = new ViewHandler(new ViewModelFactory(), primaryStage);
    viewHandler.start();

  }
}
