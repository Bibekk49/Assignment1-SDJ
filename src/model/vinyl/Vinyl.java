package model.vinyl;

import view.AlertBox;

public class Vinyl
{
  private String title;
  private String artist;
  private int year;
  private VinylState vinylState;

  public Vinyl(String title, String artist, int year)
  {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.vinylState = new AvailableState();
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public int getYear()
  {
    return year;
  }

  public VinylState getVinylState()
  {
    return vinylState;
  }

  public void setVinylState(VinylState vinylState)
  {
    this.vinylState = vinylState;
  }
  public VinylStateName getVinylStateName()
  {
    return vinylState.getVinylStateName();
  }

  public void borrowVinyl() {
    if (vinylState.getVinylStateName() == VinylStateName.RESERVED) {
      vinylState = new BorrowedAndReservedState();
    } else {
      vinylState.borrow(this);
    }
  }

  public void reserveVinyl()
  {
    vinylState.reserve(this);
  }

  public boolean hasReservation() {
    return vinylState.getVinylStateName() == VinylStateName.RESERVED;
  }
  public void returnVinyl()
  {
    if (vinylState instanceof AvailableState) {
      // If the Vinyl is already in AvailableState, show alert message
      // You can replace the following line with code to display an alert in your GUI

      AlertBox.display("Vinyl is already available.");
    } else {
      // If the Vinyl is not in AvailableState, proceed with the normal return logic
      vinylState.returnVinyl(this);
    }
  }
  public String getVinylStateNameAsString()
  {
    return vinylState.getVinylStateName().toString();
  }
}

