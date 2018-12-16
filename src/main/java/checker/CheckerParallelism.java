package checker;

import domain.line.Line;

import java.util.Objects;

public class CheckerParallelism
{
  public boolean areParallel(Line firstLine, Line secondLine)
  {
    if(firstLine.equals(secondLine)){
      return false;
    }

    Double firstGradient = firstLine.calculateGradient();
    Double secondGradient = secondLine.calculateGradient();

    return areNotCoincident(firstGradient, secondGradient)
      && Objects.equals(firstGradient, secondGradient);
  }

  private boolean areNotCoincident(Double firstGradient, Double secondGradient)
  {
    return !firstGradient.equals(0d) || !secondGradient.equals(0d);
  }
}
