package interceptor;

import domain.line.GradientInterceptLine;

public class YInterceptorCalculatorGradientInterceptor implements YInterceptorCalculator<GradientInterceptLine>
{

  public YInterceptorCalculatorGradientInterceptor()
  {
  }

  @Override
  public Double calculate(GradientInterceptLine line)
  {
    return line.getyIntercept();
  }
}
