package core;

import view.rbr.RBRViewModel;
import view.vinylList.VinylViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private VinylViewModel vinylViewModel;
  private RBRViewModel rbrViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;

  }
  public VinylViewModel getVinylViewModel() {
    if (this.vinylViewModel == null) {
      vinylViewModel = new VinylViewModel(modelFactory.getModel());
    }
    return vinylViewModel;
  }

  public RBRViewModel getRBRViewModel() {
    if (this.rbrViewModel == null) {
      this.rbrViewModel = new RBRViewModel(modelFactory.getModel());
    }
    return rbrViewModel;
  }
}
