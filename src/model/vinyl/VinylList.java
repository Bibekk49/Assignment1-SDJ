package model.vinyl;

import java.util.List;

public class VinylList
{
  private List<Vinyl> vinylList;

  String title[] = {"Vinyl1", "Vinyl2", "Vinyl3", "Vinyl4", "Vinyl5", "Vinyl6",
      "Vinyl7", "Vinyl8", "Vinyl9", "Vinyl10",};
  String artists[] = {"Aritist1", "Aritist12", "Aritist3", "Aritist4",
      "Aritist5", "Aritist6", "Aritist7", "Aritist8", "Aritist9", "Aritist10",};

  public String removeVinyl(Vinyl vinyl)
  {
    if (vinyl.getVinylStateName().equals(VinylStateName.AVAILABLE))
    {
      vinylList.remove(vinyl);
      return "Vinyl has been removed";
    }
    String currentState = vinyl.getVinylStateName().toString();
    return "Cannot remove a vinyl that is on " + currentState;

  }
  public List<Vinyl> getAllVinyls()
  {
    return vinylList;
  }
}
