package view.rbr;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ViewController;

public class RBRController implements ViewController
{
  private ViewHandler viewHandler;
  private RBRViewModel viewModel;
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModel = viewModelFactory.getRBRViewModel();

  }

  @FXML
  private void reserveVinyl() {
    viewModel.reserveVinyl();

  }
  @FXML
  private void borrowVinyl() {
    viewModel.borrowVinyl();
  }
  @FXML
  private void returnVinyl() {

    viewModel.returnVinyl();
  }

  public void back(ActionEvent actionEvent) {
    viewHandler.openMainView();
  }
}
