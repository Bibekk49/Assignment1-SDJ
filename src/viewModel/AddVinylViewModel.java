package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.VinylModel;

public class AddVinylViewModel
{
  private StringProperty title, artist, year, status;
  private VinylModel model;

  public AddVinylViewModel(VinylModel model)
  {
    title = new SimpleStringProperty();
    artist = new SimpleStringProperty();
    year = new SimpleStringProperty();
    status = new SimpleStringProperty();
  }

  public void bindTitle(StringProperty property)
  {
    property.bind(title);
  }

  public void bindArtist(StringProperty property)
  {
    property.bind(artist);
  }

  public void bindYear(StringProperty property)
  {
    property.bind(year);
  }

  public void bindStatus(StringProperty property)
  {
    property.bind(status);
  }

}
