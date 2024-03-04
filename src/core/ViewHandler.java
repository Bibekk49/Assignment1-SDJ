package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene mainScene;
  private ViewModelFactory viewModelFactory;
  private Scene reserveScene;


  public ViewHandler(ViewModelFactory viewModelFactory, Stage stage){
    this.stage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public void start(){
    openMainView();
  }

  public void openMainView() {
    if (mainScene == null){
      Parent root = loadFXML("../view/vinylList/vinyl.fxml");
      mainScene = new Scene(root);
      stage.setTitle("All vinyls");
    }
    stage.setScene(mainScene);
    stage.show();

  }

  public void openRBRView() {
    if (reserveScene == null){
      Parent root = loadFXML("../view/rbr/RBR.fxml");
      reserveScene = new Scene(root);
      stage.setTitle("All vinyls");
    }
    stage.setScene(reserveScene);
    stage.show();

  }

  private Parent loadFXML(String path) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    ViewController ctrl = loader.getController();
    ctrl.init(this, viewModelFactory);
    return root;
  }
}
