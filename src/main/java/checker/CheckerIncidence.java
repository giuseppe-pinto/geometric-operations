package checker;

import domain.line.Line;

import java.util.Objects;

public class CheckerIncidence
{
  public boolean areIncident(Line firstLine, Line secondLine)
  {
    return !Objects.equals(firstLine.calculateGradient(),
    secondLine.calculateGradient());
  }
}
