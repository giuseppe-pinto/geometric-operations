package domain.line;

import gradient.GradientCalculator;
import gradient.GradientCalculatorStrategyGradientInterceptLine;
import interceptor.YInterceptorCalculator;
import interceptor.YInterceptorCalculatorGradientInterceptor;

import java.util.Objects;

public class GradientInterceptLine implements Line
{
  private final Double gradient;
  private final Double yIntercept;
  private final GradientCalculator<GradientInterceptLine> gradientCalculator;
  private final YInterceptorCalculator<GradientInterceptLine> yInterceptorCalculator;

  public GradientInterceptLine(Double gradient,
                               Double yIntercept)
  {
    this.gradient = gradient;
    this.yIntercept = yIntercept;
    this.gradientCalculator = new GradientCalculatorStrategyGradientInterceptLine();
    this.yInterceptorCalculator = new YInterceptorCalculatorGradientInterceptor();
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
  public Double calculateGradient()
  {
    return this.gradientCalculator.calculate(this);
  }

  @Override
  public Double calculateYInterceptor()
  {
    return this.yInterceptorCalculator.calculate(this);
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