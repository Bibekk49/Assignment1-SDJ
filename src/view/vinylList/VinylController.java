package view.vinylList;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.vinyl.Vinyl;
import model.vinyl.VinylStateName;
import view.AlertBox;
import view.ViewController;

public class VinylController implements ViewController
{
  @FXML private TableView<Vinyl> tableView;
  @FXML private TableColumn<Vinyl, String> title;
  @FXML private TableColumn<Vinyl, String> artist;
  @FXML private TableColumn<Vinyl, Integer> year;
  @FXML private TableColumn<Vinyl, VinylStateName> state;
  private ViewHandler viewHandler;
  private VinylViewModel viewModel;

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModelFactory.getVinylViewModel();

    initTable();
  }
  private void initTable() {
    title.setCellValueFactory(new PropertyValueFactory<>("title"));
    artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
    year.setCellValueFactory(new PropertyValueFactory<>("year"));
    state.setCellValueFactory(new PropertyValueFactory<>("vinylStateNameAsString"));
    tableView.setItems(viewModel.getAllVinyls());
  }
 @FXML private void next() {
    if (!vinylSelected()) {
      AlertBox.display("Select a vinyl to continue");
      return;
    }
    viewModel.setSelectedVinyl(tableView.getSelectionModel().getSelectedItem());
    viewHandler.openRBRView();
  }
  private boolean vinylSelected() {
    return tableView.getSelectionModel().getSelectedItem() != null;
  }
}
