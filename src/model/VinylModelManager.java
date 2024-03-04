package model;

import model.vinyl.Vinyl;
import model.vinyl.VinylList;
import util.EventDTO;
import util.PropertyChange;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class VinylModelManager implements VinylModel
{
  private PropertyChangeSupport support;
  private Vinyl selectedVinyl;
  private VinylList vinyls;

  public VinylModelManager()
  {
    this.support = new PropertyChangeSupport(this);
    vinyls = new VinylList();
  }

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    vinyl.reserveVinyl();
    support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(),
        null, vinyl);

  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    vinyl.borrowVinyl();
    support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(),
        null, vinyl);

  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    vinyl.returnVinyl();
    support.firePropertyChange(PropertyChange.VINYL_STATE_CHANGED.toString(),
        null, vinyl);
  }

  public void removeVinyl(Vinyl selectedVinyl)
  {
    String state = vinyls.removeVinyl(selectedVinyl);
    support.firePropertyChange(PropertyChange.VINYL_REMOVED.toString(),
        selectedVinyl, new EventDTO(state, null));
  }

  @Override public Vinyl getSelectedVinyl()
  {
    return selectedVinyl;
  }

  @Override public void setSelectedVinyl(Vinyl vinyl)
  {
    selectedVinyl = vinyl;
  }

  @Override public List<Vinyl> getAllVinyls()
  {
    return vinyls.getAllVinyls();
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);

  }
}
