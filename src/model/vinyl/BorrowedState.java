package model.vinyl;

public class BorrowedState implements VinylState
{
  @Override public void reserve(Vinyl vinyl)
  {
vinyl.setVinylState(new ReservedState());
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
vinyl.setVinylState(new AvailableState());
  }

  @Override public void borrow(Vinyl vinyl)
  {
//already borrowed
  }

  @Override public VinylStateName getVinylStateName()
  {
    return VinylStateName.BORROWED;
  }
}
