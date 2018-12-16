package gradient;

import domain.line.GradientInterceptLine;

public class GradientCalculatorStrategyGradientInterceptLine implements GradientCalculator<GradientInterceptLine>
{
  @Override
  public Double calculate(GradientInterceptLine line)
  {
    return line.getGradient();
  }
}