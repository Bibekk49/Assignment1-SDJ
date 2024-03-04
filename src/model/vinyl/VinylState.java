package model.vinyl;

public interface VinylState
{
  void reserve(Vinyl vinyl);
  void returnVinyl(Vinyl vinyl);
  void borrow(Vinyl vinyl);
  VinylStateName getVinylStateName();
}
