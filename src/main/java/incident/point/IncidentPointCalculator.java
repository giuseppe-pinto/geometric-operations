package incident.point;

import checker.CheckerIncidence;
import domain.Point;

public abstract class IncidentPointCalculator<T>
{
  private final CheckerIncidence<T> checkerIncidence;

  public IncidentPointCalculator(CheckerIncidence<T> checkerIncidence)
  {
    this.checkerIncidence = checkerIncidence;
  }

  public CheckerIncidence<T> getCheckerIncidence()
  {
    return checkerIncidence;
  }

  public abstract Point calculate(T firstLine, T secondLine);
}
