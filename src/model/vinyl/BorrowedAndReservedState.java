package model.vinyl;

public class BorrowedAndReservedState implements VinylState
{
  @Override public void reserve(Vinyl vinyl)
  {
//already reserved
  }

  @Override public void borrow(Vinyl vinyl)
  {
   //already borrowed
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
   vinyl.setVinylState(new AvailableState());
  }

  @Override public VinylStateName getVinylStateName()
  {
    return VinylStateName.BORROWED_AND_RESERVED;
  }
}
