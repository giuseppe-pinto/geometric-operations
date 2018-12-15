package incident.point;

import checker.CheckerIncidence;
import domain.Point;
import domain.line.StandardLine;

public class IncidentPointCalculatorStandardLine extends IncidentPointCalculator<StandardLine>
{
  public IncidentPointCalculatorStandardLine(CheckerIncidence<StandardLine> checkerIncidence)
  {
    super(checkerIncidence);
  }

  @Override
  public Point calculate(StandardLine firstLine, StandardLine secondLine)
  {
    return null;
  }
}
