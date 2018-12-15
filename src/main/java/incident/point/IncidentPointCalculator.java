package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import gradient.GradientCalculatorStrategy;
import interceptor.YInterceptorCalculator;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class IncidentPointCalculator<T>
{
  private static final int SCALE = 2;
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

  public Point calculate(T firstLine, T secondLine) throws RuntimeException
  {
    Double firstGradient = getGradientCalculatorStrategy().calculate(firstLine);
    Double secondGradient = getGradientCalculatorStrategy().calculate(secondLine);

    if(firstGradient == null || secondGradient == null)
      throw new RuntimeException("The two lines aren't incident");

    if(!getCheckerIncidence().areIncident(firstLine,secondLine))
      throw new RuntimeException("The two lines aren't incident");

    Double firstA = (-1) * firstGradient;
    Double B = 1.0;
    Double firstC = getInterceptorCalculator().calculate(firstLine);
    Double secondA = (-1) * secondGradient;
    Double secondC = getInterceptorCalculator().calculate(secondLine);

    Double delta = firstA * B - B * secondA;

    Double x = roundToScale((firstC * B - B * secondC) / delta);
    Double y = roundToScale((firstA * secondC - firstC * secondA) / delta);

    return new Point(x,y);
  }

  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }
}