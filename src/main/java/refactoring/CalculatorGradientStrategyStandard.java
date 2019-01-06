package refactoring;

import domain.line.StandardLine;

public class CalculatorGradientStrategyStandard implements GradientCalculator<StandardLine>
{
  @Override
  public Double calculate(StandardLine line)
  {
    return 1.0;
  }
}
