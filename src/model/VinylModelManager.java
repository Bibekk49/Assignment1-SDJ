package model;

import core.ModelFactory;
import model.util.VinylActionThreads;
import model.vinyl.Vinyl;
import model.vinyl.VinylList;
import model.util.EventDTO;
import model.util.PropertyChange;
import model.vinyl.VinylStateName;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.logging.Logger;

public class VinylModelManager implements VinylModel {
  private PropertyChangeSupport support;
  private Vinyl selectedVinyl;
  private VinylList vinyls;

  public VinylModelManager(ModelFactory modelFactory) {
    this.support = new PropertyChangeSupport(this);
    vinyls = new VinylList();
  }

  // Inside VinylModelManager class
  @Override
  public void reserveVinyl(Vinyl vinyl) {
    if (vinyl.getVinylStateName() == VinylStateName.BORROWED) {
      // Vinyl is borrowed by someone else, allow reservation
      vinyl.reserveVinyl();
      support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(), null, vinyl);
      Logger.getLogger(VinylActionThreads.class.getName());
    } else if (vinyl.getVinylStateName() == VinylStateName.AVAILABLE && !vinyl.hasReservation()) {
      // Reserve the Vinyl
      vinyl.reserveVinyl();
      support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(), null, vinyl);
      Logger.getLogger(VinylActionThreads.class.getName());
    }
  }

  @Override
  public void borrowVinyl(Vinyl vinyl) {
    if ((vinyl.getVinylStateName() == VinylStateName.RESERVED && vinyl == selectedVinyl) ||
            vinyl.getVinylStateName() == VinylStateName.AVAILABLE) {
      // Borrow the Vinyl only if it's reserved by the user or available
      vinyl.borrowVinyl();
      support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(), null, vinyl);

      // If the vinyl was reserved before, also update the state to Reserved
      if (vinyl.hasReservation()) {
        support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(), null, vinyl);
      }

      Logger.getLogger(VinylActionThreads.class.getName());
    }
  }



  @Override
  public void returnVinyl(Vinyl vinyl) {
    if (vinyl.getVinylStateName() != VinylStateName.AVAILABLE) {
      // Return the Vinyl only if it's not already in the available state
      vinyl.returnVinyl();
      support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(), null, vinyl);
    }
  }

  public void removeVinyl(Vinyl selectedVinyl) {
    String state = vinyls.removeVinyl(selectedVinyl);
    support.firePropertyChange(PropertyChange.VINYL_REMOVED.toString(),
            selectedVinyl, new EventDTO(state, null));
  }

  @Override
  public Vinyl getSelectedVinyl() {
    return selectedVinyl;
  }

  @Override
  public void setSelectedVinyl(Vinyl vinyl) {
    selectedVinyl = vinyl;
  }

  @Override
  public List<Vinyl> getAllVinyls() {
    return vinyls.getAllVinyls();
  }

  @Override
  public void addListener(String eventName,
                          PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName,
                             PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);

  }
}
