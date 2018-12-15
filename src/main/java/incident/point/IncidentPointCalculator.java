package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import gradient.GradientCalculatorStrategy;
import interceptor.YInterceptorCalculator;

public abstract class IncidentPointCalculator<T>
{
  private final CheckerIncidence<T> checkerIncidence;
  private final YInterceptorCalculator<T> interceptorCalculator;
  private final GradientCalculatorStrategy<T> gradientCalculatorStrategy;

  public IncidentPointCalculator(CheckerIncidence<T> checkerIncidence,
                                 YInterceptorCalculator<T> interceptorCalculator,
                                 GradientCalculatorStrategy<T> gradientCalculatorStrategy)
  {
    this.checkerIncidence = checkerIncidence;
    this.interceptorCalculator = interceptorCalculator;
    this.gradientCalculatorStrategy = gradientCalculatorStrategy;
  }

  public CheckerIncidence<T> getCheckerIncidence()
  {
    return checkerIncidence;
  }

  public YInterceptorCalculator<T> getInterceptorCalculator()
  {
    return interceptorCalculator;
  }

  public GradientCalculatorStrategy<T> getGradientCalculatorStrategy()
  {
    return gradientCalculatorStrategy;
  }

  public abstract Point calculate(T firstLine, T secondLine) throws RuntimeException;


}
