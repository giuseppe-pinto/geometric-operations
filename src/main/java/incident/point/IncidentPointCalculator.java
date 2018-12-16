package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.Line;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class IncidentPointCalculator
{
  private static final int SCALE = 2;

  private final CheckerIncidence checkerIncidence;

  public IncidentPointCalculator(CheckerIncidence checkerIncidence)
  {
    this.checkerIncidence = checkerIncidence;
  }

  public CheckerIncidence getCheckerIncidence()
  {
    return checkerIncidence;
  }

  public Point calculate(Line firstLine, Line secondLine)
  {
    Double firstGradient = firstLine.calculateGradient();
    Double secondGradient = secondLine.calculateGradient();

    if(!getCheckerIncidence().areIncident(firstLine,secondLine))
      throw new IncidentPointCalculatorException("The two lines aren't incident");

    Double firstA = (-1) * firstGradient;
    Double B = 1.0;
    Double firstC = firstLine.calculateYInterceptor();
    Double secondA = (-1) * secondGradient;
    Double secondC = secondLine.calculateYInterceptor();

    Double delta = firstA * B - B * secondA;

    Double x = roundToScale((firstC * B - B * secondC) / delta);
    Double y = roundToScale((firstA * secondC - firstC * secondA) / delta);

    return new Point(x,y);
  }

  private Double roundToScale(Double value) {
    return new BigDecimal(value.toString()).setScale(SCALE, HALF_UP).doubleValue();
  }

  private class IncidentPointCalculatorException extends IllegalArgumentException
  {
    public IncidentPointCalculatorException(String s)
    {
      super(s);
    }
  }
}