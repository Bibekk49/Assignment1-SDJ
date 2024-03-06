package core;

import model.VinylModel;
import model.VinylModelManager;

public class ModelFactory
{
  private VinylModel model;
  private ModelFactory modelFactory;

  public VinylModel getModel() {
    if (model == null) {
      model = new VinylModelManager(modelFactory);
    }
    return model;
  }
}
