package domain.line;

import java.util.Objects;

public class GradientInterceptLine
{
  private final Double gradient;
  private final Double yIntercept;

  public GradientInterceptLine(Double gradient, Double yIntercept)
  {
    this.gradient = gradient;
    this.yIntercept = yIntercept;
  }

  public Double getGradient()
  {
    return gradient;
  }

  public Double getyIntercept()
  {
    return yIntercept;
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
    GradientInterceptLine that = (GradientInterceptLine) o;
    return Objects.equals(gradient, that.gradient) &&
      Objects.equals(yIntercept, that.yIntercept);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(gradient, yIntercept);
  }

  @Override
  public String toString()
  {
    return "GradientInterceptLine{" +
      "gradient=" + gradient +
      ", yIntercept=" + yIntercept +
      '}';
  }
}
