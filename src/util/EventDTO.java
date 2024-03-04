package util;

import java.util.Objects;

public final class EventDTO
{
  private final String description;
  private final Object newValue;

  public EventDTO(String description, Object newValue)
  {
    this.description = description;
    this.newValue = newValue;
  }

  public String description()
  {
    return description;
  }

  public Object newValue()
  {
    return newValue;
  }

  @Override public boolean equals(Object obj)
  {
    if (obj == this)
      return true;
    if (obj == null || obj.getClass() != this.getClass())
      return false;
    var that = (EventDTO) obj;
    return Objects.equals(this.description, that.description) && Objects.equals(
        this.newValue, that.newValue);
  }

  @Override public int hashCode()
  {
    return Objects.hash(description, newValue);
  }

  @Override public String toString()
  {
    return "EventDTO[" + "description=" + description + ", " + "newValue="
        + newValue + ']';
  }
}