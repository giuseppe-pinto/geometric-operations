package domain.line;

import domain.Point;

import java.util.Objects;

public class StandardLine
{

  private final Point a;
  private final Point b;

  public StandardLine(Point a, Point b)
  {
    this.a = a;
    this.b = b;
  }

  public Point getA()
  {
    return a;
  }

  public Point getB()
  {
    return b;
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
    StandardLine that = (StandardLine) o;
    return Objects.equals(a, that.a) &&
      Objects.equals(b, that.b);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(a, b);
  }

  @Override
  public String toString()
  {
    return "StandardLine{" +
      "a=" + a +
      ", b=" + b +
      '}';
  }
}