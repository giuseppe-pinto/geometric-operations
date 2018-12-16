package checker;

import domain.line.Line;

public class CheckerPerpendicularity
{
  private static final Double PRODUCT_OF_GRADIENT_FOR_PERPENDICULARITY = -1d;

  public boolean arePerpendicular(Line firstLine, Line secondLine)
  {
    Double firstGradient = firstLine.calculateGradient();
    Double secondGradient = secondLine.calculateGradient();

    return areOrthogonal(firstGradient, secondGradient) || getProductOfTwoGradient(firstGradient, secondGradient).equals(PRODUCT_OF_GRADIENT_FOR_PERPENDICULARITY);
  }

  private boolean areOrthogonal(Double firstGradient, Double secondGradient)
  {
    return (firstGradient.isInfinite() && secondGradient.equals(0.0))
      || (secondGradient.isInfinite() && firstGradient.equals(0.0));
  }

  private Double getProductOfTwoGradient(Double firstGradient, Double secondGradient)
  {
    return (firstGradient * secondGradient);
  }
}