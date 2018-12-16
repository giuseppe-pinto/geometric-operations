package interceptor;

import domain.line.GradientInterceptLine;

import java.util.Optional;

public class YInterceptorCalculatorGradientInterceptor implements YInterceptorCalculator<GradientInterceptLine>
{
  @Override
  public Double calculate(GradientInterceptLine line)
  {
    return Optional.ofNullable(line.getyIntercept())
      .orElseThrow(() ->
        new YInterceptorCalculatorGradientInterceptoreException("The line can not be null"));
  }

  private class YInterceptorCalculatorGradientInterceptoreException extends IllegalArgumentException
  {
    public YInterceptorCalculatorGradientInterceptoreException(
      String message)
    {
      super(message);
    }
  }
}
