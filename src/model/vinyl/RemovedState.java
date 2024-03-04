package model.vinyl;

public class RemovedState implements VinylState
{
  @Override public void reserve(Vinyl vinyl)
  {
    //can't reserve removed vinyl
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    //the vinyl should already be in available state to get removed
  }

  @Override public void borrow(Vinyl vinyl)
  {
    //can't borrow removed vinyl
  }

  @Override public VinylStateName getVinylStateName()
  {
    return VinylStateName.REMOVED;
  }
}
