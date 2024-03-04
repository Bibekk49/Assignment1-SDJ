package model.vinyl;

public class ReservedState implements VinylState
{
  @Override public void reserve(Vinyl vinyl)
  {
//already reserved
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
vinyl.setVinylState(new AvailableState());
  }

  @Override public void borrow(Vinyl vinyl)
  {
vinyl.setVinylState(new BorrowedState());
  }

  @Override public VinylStateName getVinylStateName()
  {
    return VinylStateName.RESERVED;
  }
}
