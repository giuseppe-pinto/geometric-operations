package domain.line;

import domain.Point;
import gradient.GradientCalculator;
import gradient.GradientCalculatorStandardLine;
import interceptor.YInterceptorCalculator;
import interceptor.YInterceptorCalculatorStandard;

import java.util.Objects;

public class StandardLine implements Line
{
  private final Point a;
  private final Point b;
  private final GradientCalculator<StandardLine> calculatorGradient;
  private final YInterceptorCalculator<StandardLine> yInterceptorCalculator;

  public StandardLine(Point a,
                      Point b)
  {
    this.a = a;
    this.b = b;
    this.calculatorGradient = new GradientCalculatorStandardLine();
    this.yInterceptorCalculator = new YInterceptorCalculatorStandard();
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
  public Double calculateGradient()
  {
    return this.calculatorGradient.calculate(this);
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