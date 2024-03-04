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
    ViewHandler view = new ViewHandler(viewModelFactory, primaryStage);
    view.start();
  }
}
