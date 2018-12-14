package domain;

import java.util.Objects;

public class Point
{

  private final Double abscissa;
  private final Double ordinate;

  public Point(Double abscissa, Double ordinate)
  {
    this.abscissa = abscissa;
    this.ordinate = ordinate;
  }

  public Double getAbscissa()
  {
    return abscissa;
  }

  public Double getOrdinate()
  {
    return ordinate;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    Point point = (Point) o;
    return Objects.equals(abscissa, point.abscissa) &&
      Objects.equals(ordinate, point.ordinate);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(abscissa, ordinate);
  }

  @Override
  public String toString()
  {
    return "Point{" +
      "abscissa=" + abscissa +
      ", ordinate=" + ordinate +
      '}';
  }
}