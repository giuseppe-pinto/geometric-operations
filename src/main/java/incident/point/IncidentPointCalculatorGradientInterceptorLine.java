package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.GradientInterceptLine;
import gradient.GradientCalculatorStrategy;
import interceptor.YInterceptorCalculator;

import java.math.BigDecimal;
import java.util.Arrays;

import static java.math.RoundingMode.HALF_UP;

public class IncidentPointCalculatorGradientInterceptorLine extends IncidentPointCalculator<GradientInterceptLine>
{
  private static final int SCALE = 2;

  public IncidentPointCalculatorGradientInterceptorLine(CheckerIncidence<GradientInterceptLine> checkerIncidence,
                                                        YInterceptorCalculator<GradientInterceptLine> interceptorCalculator,
                                                        GradientCalculatorStrategy<GradientInterceptLine> gradientCalculatorStrategy)
  {
    super(checkerIncidence, interceptorCalculator, gradientCalculatorStrategy);
  }

  @Override
  public Point calculate(GradientInterceptLine firstLine, GradientInterceptLine secondLine) throws RuntimeException
  {
    if(!getCheckerIncidence().areIncident(firstLine,secondLine))
      throw new IncidentPointCalculatorException("The two lines aren't incident");

    Double firstA = (-1) * getGradientCalculatorStrategy().calculate(firstLine);
    Double B = 1.0;
    Double firstC = getInterceptorCalculator().calculate(firstLine);
    Double secondA = (-1) * getGradientCalculatorStrategy().calculate(secondLine);
    Double secondC = getInterceptorCalculator().calculate(secondLine);

    Double delta = firstA * B - B * secondA;

    Double x = roundToScale((firstC * B - B * secondC) / delta);
    Double y = roundToScale((firstA * secondC - firstC * secondA) / delta);

    return new Point(x,y);
  }

  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }

  private class IncidentPointCalculatorException extends RuntimeException{
    public IncidentPointCalculatorException(String message)
    {
      super(message);
    }
  }
}
