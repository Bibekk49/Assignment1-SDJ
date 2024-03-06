package model;

import model.vinyl.Vinyl;
import util.PropertyChangeSubject;

import java.util.List;

public interface VinylModel extends PropertyChangeSubject
{
  void reserveVinyl(Vinyl vinyl);

  void borrowVinyl(Vinyl vinyl);

  Vinyl getSelectedVinyl();

  void setSelectedVinyl(Vinyl vinyl);

  void returnVinyl(Vinyl vinyl);

  List<Vinyl> getAllVinyls();

  void removeVinyl(Vinyl selectedVinyl);
}
