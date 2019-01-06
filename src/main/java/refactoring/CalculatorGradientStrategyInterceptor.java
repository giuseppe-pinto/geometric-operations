package refactoring;

import domain.line.GradientInterceptLine;

public class CalculatorGradientStrategyInterceptor implements GradientCalculator<GradientInterceptLine>
{
  @Override
  public Double calculate(GradientInterceptLine line)
  {
    return 2.0;
  }
}
