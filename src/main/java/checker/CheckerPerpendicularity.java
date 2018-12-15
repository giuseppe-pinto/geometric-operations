package checker;

import gradient.GradientCalculatorStrategy;

public class CheckerPerpendicularity<T>
{
  private static final Double PRODUCT_OF_GRADIENT_FOR_PERPENDICULARITY = -1d;

  private GradientCalculatorStrategy<T> gradientCalculatorStrategy;

  public CheckerPerpendicularity(GradientCalculatorStrategy<T> gradientCalculatorStrategy)
  {
    this.gradientCalculatorStrategy = gradientCalculatorStrategy;
  }

  public boolean arePerpendicular(T firstLine, T secondLine)
  {
    Double firstGradient = gradientCalculatorStrategy.calculate(firstLine);
    Double secondGradient = gradientCalculatorStrategy.calculate(secondLine);

    return ((firstGradient.isInfinite() && secondGradient.equals(0.0))
      || (secondGradient.isInfinite() && firstGradient.equals(0.0))) ||
      getProductOfTwoGradient(firstGradient, secondGradient).equals(PRODUCT_OF_GRADIENT_FOR_PERPENDICULARITY);
  }

  private Double getProductOfTwoGradient(Double firstGradient, Double secondGradient)
  {
    return (firstGradient * secondGradient);
  }
}