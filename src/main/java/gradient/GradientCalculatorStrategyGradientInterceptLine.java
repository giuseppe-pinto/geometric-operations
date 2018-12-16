package gradient;

import domain.line.GradientInterceptLine;

import java.util.Optional;

public class GradientCalculatorStrategyGradientInterceptLine implements GradientCalculator<GradientInterceptLine>
{
  @Override
  public Double calculate(GradientInterceptLine line)
  {
    return Optional
      .ofNullable(line.getGradient())
      .orElseThrow(() -> new GradientCalculatorGradientInterceptLineException("Gradient of a line must not be null"));
  }

  private class GradientCalculatorGradientInterceptLineException extends IllegalArgumentException
  {
    public GradientCalculatorGradientInterceptLineException(
      String message)
    {
      super(message);
    }
  }
}