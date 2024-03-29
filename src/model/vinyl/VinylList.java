package model.vinyl;

import java.util.ArrayList;
import java.util.List;

public class VinylList
{
  private List<Vinyl> vinylList;

  String title[] = {"Vinyl1", "Vinyl2", "Vinyl3", "Vinyl4", "Vinyl5", "Vinyl6",
      "Vinyl7", "Vinyl8", "Vinyl9", "Vinyl10",};
  String artists[] = {"Aritist1", "Aritist2", "Aritist3", "Aritist4",
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


  private void initList()
  {
    vinylList = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      vinylList.add(new Vinyl(title[i % (title.length)], artists[i % (artists.length)],
          (1960 + (i * 2))));
    }

  }

  public List<Vinyl> getAllVinyls()
  {
    if (vinylList == null) {
      initList();
    }
    return vinylList;
  }
}
