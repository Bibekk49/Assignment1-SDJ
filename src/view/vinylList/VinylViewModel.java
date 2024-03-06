package view.vinylList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.VinylModel;
import model.vinyl.Vinyl;
import model.util.EventDTO;
import model.util.PropertyChange;
import view.AlertBox;

import java.beans.PropertyChangeEvent;

public class VinylViewModel
{
  private VinylModel model;
  private ObservableList<Vinyl> vinyls;
  public VinylViewModel(VinylModel model) {
    vinyls = FXCollections.observableArrayList();
    this.model = model;
    this.model.addListener(PropertyChange.VINYL_STATE_CHANGED.toString(), this::listenToPropertyChange);
    this.model.addListener(PropertyChange.VINYL_REMOVED.toString(), this::listenToVinylRemoval);
  }

  private void listenToVinylRemoval(PropertyChangeEvent propertyChangeEvent) {
    String description = ((EventDTO) propertyChangeEvent.getNewValue()).description();
    AlertBox.display(description);
    fetchVinyls();
  }

  private void listenToPropertyChange(PropertyChangeEvent propertyChangeEvent) {
    fetchVinyls();
  }

  private boolean fetchVinyls() {
    return vinyls.setAll(model.getAllVinyls());
  }

  public ObservableList<Vinyl> getAllVinyls() {
    fetchVinyls();
    return vinyls;
  }

  public void setSelectedVinyl(Vinyl selectedItem) {
    model.setSelectedVinyl(selectedItem);
  }

  public void removeVinyl() {
    model.removeVinyl(model.getSelectedVinyl());
  }
}
