package core;

import model.VinylModel;
import model.VinylModelManager;

public class ModelFactory
{
  private VinylModel model;
  public VinylModel getModel() {
    if (model == null) {
      model = new VinylModelManager();
    }
    return model;
  }
}
