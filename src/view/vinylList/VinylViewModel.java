package view.vinylList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.VinylModel;
import model.util.Threads.VinylActionThreads;
import model.vinyl.Vinyl;
import model.util.EventDTO;
import model.util.PropertyChange;
import model.vinyl.VinylStateName;
import view.AlertBox;

import java.beans.PropertyChangeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VinylViewModel {
  private VinylModel model;
  private ObservableList<Vinyl> vinyls;


  private final Logger logger = Logger.getLogger(VinylActionThreads.class.getName());


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

  private void fetchVinyls() {
    vinyls.setAll(model.getAllVinyls());
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

  // Inside VinylViewModel class
  public void borrowVinyl() {
    Vinyl selectedVinyl = model.getSelectedVinyl();
    String description = "";

    if (selectedVinyl != null) {
      if (selectedVinyl.getVinylState().getVinylStateName() == VinylStateName.AVAILABLE
              || selectedVinyl.getVinylState().getVinylStateName() == VinylStateName.RESERVED) {
        model.borrowVinyl(selectedVinyl);
        description = "Vinyl has been borrowed";
      } else if (selectedVinyl.getVinylState().getVinylStateName() == VinylStateName.BORROWED) {
        description = "Vinyl is already borrowed";
      } else {
        description = "Vinyl cannot be borrowed in the current state.";
      }
    }

    AlertBox.display(description);
    logger.log(Level.INFO, description);
  }

  public void returnVinyl() {
    Vinyl selectedVinyl = model.getSelectedVinyl();
    String description = "";

    if (selectedVinyl != null) {
      if (selectedVinyl.getVinylState().getVinylStateName() == VinylStateName.BORROWED) {
        model.returnVinyl(selectedVinyl);
        description = "Vinyl has been returned";
      } else if (selectedVinyl.getVinylState().getVinylStateName() == VinylStateName.AVAILABLE) {
        description = "Vinyl is already available";
      } else {
        description = "Vinyl cannot be returned in the current state.";
      }
    }

    AlertBox.display(description);
    logger.log(Level.INFO, description);
  }
}
