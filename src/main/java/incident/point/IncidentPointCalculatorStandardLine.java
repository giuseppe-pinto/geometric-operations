package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.StandardLine;
import gradient.GradientCalculatorStrategy;
import interceptor.YInterceptorCalculator;

public class IncidentPointCalculatorStandardLine extends IncidentPointCalculator<StandardLine>
{
  public IncidentPointCalculatorStandardLine(CheckerIncidence<StandardLine> checkerIncidence,
                                             YInterceptorCalculator<StandardLine> interceptorCalculator,
                                             GradientCalculatorStrategy<StandardLine> gradientCalculatorStrategy)
  {
    super(checkerIncidence, interceptorCalculator, gradientCalculatorStrategy);
  }

  @Override
  public Point calculate(StandardLine firstLine, StandardLine secondLine)
  {
    return null;
  }
}
