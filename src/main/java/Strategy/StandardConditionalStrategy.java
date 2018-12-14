package Strategy;

import domain.Point;
import domain.line.StandardLine;

import java.util.Objects;

public class StandardConditionalStrategy implements ConditionalStrategy<StandardLine>
{
  @Override
  public boolean areParallel(StandardLine firstLine, StandardLine secondLine)
  {
    return Objects.equals(calculateGradient(firstLine), calculateGradient(secondLine));
  }

  @Override
  public boolean arePerpendicular(StandardLine firstLine, StandardLine secondLine)
  {
    return false;
  }

  @Override
  public Point areIncident(StandardLine firstLine, StandardLine secondLine)
  {
    return null;
  }

  private Double calculateGradient(StandardLine line)
  {
    double numerator = line.getA().getOrdinate() - line.getB().getOrdinate();
    double denominator = line.getA().getAbscissa() - line.getB().getAbscissa();
    return numerator/denominator;
  }
}
