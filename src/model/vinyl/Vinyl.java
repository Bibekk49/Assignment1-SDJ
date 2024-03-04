package model.vinyl;

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

  public void borrowVinyl()
  {
    vinylState.borrow(this);
  }

  public void reserveVinyl()
  {
    vinylState.reserve(this);
  }

  public void returnVinyl()
  {
    vinylState.returnVinyl(this);
  }
  public String getVinylStateNameAsString()
  {
    return vinylState.getVinylStateName().toString();
  }
}

