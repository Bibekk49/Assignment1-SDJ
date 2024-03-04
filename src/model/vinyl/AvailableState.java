package model.vinyl;

public class AvailableState implements VinylState
{
  @Override public void reserve(Vinyl vinyl)
  {
    vinyl.setVinylState(new ReservedState());
  }

  @Override public void borrow(Vinyl vinyl)
  {
    vinyl.setVinylState(new BorrowedState());
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    //vinyl is already available so nothing to do here
  }

  @Override public VinylStateName getVinylStateName()
  {
    return VinylStateName.AVAILABLE;
  }
}
