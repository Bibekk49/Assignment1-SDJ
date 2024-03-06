package view.rbr;
import model.VinylModel;
import model.vinyl.Vinyl;
import model.util.PropertyChange;
import view.AlertBox;

import java.beans.PropertyChangeEvent;

public class RBRViewModel
{
  private VinylModel vinylModel;

  public RBRViewModel(VinylModel model) {
    this.vinylModel = model;
    vinylModel.addListener(PropertyChange.VINYL_STATE_CHANGED.toString(),this::listenToStateChange);
  }

  private void listenToStateChange(PropertyChangeEvent propertyChangeEvent) {
    Vinyl newValue = (Vinyl) propertyChangeEvent.getNewValue();
    AlertBox.display("State changed to :" + newValue.getVinylStateName().toString());

  }

  public void reserveVinyl() {
    vinylModel.reserveVinyl(vinylModel.getSelectedVinyl());
  }

  public void borrowVinyl() {
    vinylModel.borrowVinyl(vinylModel.getSelectedVinyl());
  }

  public void returnVinyl() {
    vinylModel.returnVinyl(vinylModel.getSelectedVinyl());
  }
}
