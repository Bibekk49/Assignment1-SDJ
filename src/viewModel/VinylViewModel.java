package viewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.VinylModel;
import model.vinyl.Vinyl;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class VinylViewModel
{

  private List<Vinyl> vinylList;
  private ListProperty<String> listview;
  private ObservableList<String> vinyls;
  private ObservableList<Vinyl> vinylLists;

  private Vinyl vinyl;
  private VinylModel model;

  public VinylViewModel(VinylModel model)
  {
    this.model = model;
    listview = new SimpleListProperty<>();
    vinyls = FXCollections.observableArrayList();
    vinylList = FXCollections.observableArrayList();
    model.addListener("addVinyl", this::newVinylAdded);

  }

  private void newVinylAdded(PropertyChangeEvent propertyChangeEvent)
  {
    Vinyl vinyl = (Vinyl) propertyChangeEvent.getNewValue();
    vinyls.add(vinyl.getTitle());
    listview.set(vinyls);
    vinylList.add(vinyl);
  }

  private void bindingListView(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(listview);
  }

  public void reserve(Vinyl vinyl)
  {
    model.reserveVinyl(vinyl);
  }

  public List<Vinyl> getVinylList()
  {
    return vinylList;
  }

}
